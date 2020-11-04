package com.lyw.model.mybatis.test;

import com.lyw.model.mybatis.annotation.Param;
import com.lyw.model.mybatis.annotation.Select;
import com.lyw.model.mybatis.mapper.UserMapper;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * eg:
 * <code>
 *     select * form table_name where id = #{id} and username = #{username}
 * </code><br/>
 * <code>
 *     select * form table_name where id = 2235 and username = fdsaf
 * </code>
 * @author lyw
 * @date 2020/11/04 22:06
 */
public class Test {
    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(Test.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Map<String, Object> map = buildMethodArgNameMap(method, args);
                System.err.println(Arrays.toString(args));
                Select annotation = method.getAnnotation(Select.class);
                if (annotation == null)
                    throw new RuntimeException("Select注解中的SQL语句为空");
                String[] value = annotation.value();
                String sql = parseSQL(value[0], map);
                System.err.println("sql:" + sql);
                return null;
            }
        });
        userMapper.getPart(2235, "fdsaf");
    }

    private static String parseSQL(String sql, Map<String, Object> methodArgMap) {
        StringBuilder sb = new StringBuilder();
        int length = sql.length();
        for (int i = 0; i < length; i++) {
            char c = sql.charAt(i);
            if (c != '#') {
                sb.append(c);
                continue;
            }
            int nextIndex = i + 1;
            if (sql.charAt(nextIndex) != '{')
                throw new RuntimeException(String.format("这里应该为#\nsql:%s\nindex:%d", sb.toString(), nextIndex));
            StringBuilder argSB = new StringBuilder();
            i = parseSQLArg(argSB, sql, nextIndex);
            String argName = argSB.toString();
            Object argValue = methodArgMap.get(argName);
            sb.append(argValue.toString());
        }
        return sb.toString();
    }

    private static int parseSQLArg(StringBuilder argSB, String sql, int nextIndex) {
        nextIndex++;
        for (; nextIndex < sql.length(); nextIndex++) {
            char c = sql.charAt(nextIndex);
            if (c != '}') {
                argSB.append(c);
                continue;
            }
            return nextIndex;
        }
        throw new RuntimeException(String.format("缺少右括号\nindex:%d", nextIndex));
    }

    /**
     * 方法的形参跟入参， 建立关系
     *
     * @param method 方法的形参名称
     * @param args   方法的实际入参
     * @return 建立关系后的哈希表
     */
    private static Map<String, Object> buildMethodArgNameMap(Method method, Object[] args) {
        Map<String, Object> nameArgMap = new HashMap<String, Object>(16);
        Parameter[] parameters = method.getParameters();
        if (parameters.length != args.length)
            throw new RuntimeException("方法入参与解析参数数量不一致");
        int[] index = {0};
        Arrays.asList(parameters).forEach(parameter -> {
            Param annotation = parameter.getAnnotation(Param.class);
            if (annotation == null)
                throw new RuntimeException("Param注解中的方法形参为空");
            String value = annotation.value();
            nameArgMap.put(value, args[index[0]]);
            index[0]++;
        });
        return nameArgMap;
    }
}
