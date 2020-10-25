package com.lyw.model.signleton;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 *   饿汉式
 * @author lyw
 * @date 2020/10/15 21:06
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {}

    //静态工厂方法，提供了一个供外部访问得到对象的静态方法
    public static Singleton getInstance() {
        return instance;
    }
}
