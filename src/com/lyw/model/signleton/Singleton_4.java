package com.lyw.model.signleton;

/**
 * @author lyw
 * @date 2020/10/15 21:25
 */
public class Singleton_4 extends Singleton_3 {

    public Singleton_4() {
    }

    public static Singleton_4 getInstance() {
        return (Singleton_4) Singleton_3.getInstance("Singleton_4");
    }
}
