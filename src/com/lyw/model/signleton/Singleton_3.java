package com.lyw.model.signleton;

import java.util.HashMap;

/**
 * @author lyw
 * @date 2020/10/15 21:13
 */
public class Singleton_3 {

    // 用来存放对应关系
    private static HashMap<Object, Object> sinRegistry = new HashMap<Object, Object>(16);
    private static Singleton_3 instance = new Singleton_3();

    protected Singleton_3() {
    }

    public static Singleton_3 getInstance(String name) {
        if (name == null) {
            name = "Singleton_3";
        }
        if (sinRegistry.get(name) == null) {
            try {
                sinRegistry.put(name, Class.forName(name).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (Singleton_3) sinRegistry.get(name);
    }
}
