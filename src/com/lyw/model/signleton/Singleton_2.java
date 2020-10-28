package com.lyw.model.signleton;

import java.time.format.SignStyle;

/**
 *   懒汉式
 * @author lyw
 * @date 2020/10/15 21:07
 */
public class Singleton_2 {
    private static Singleton_2 instance = null;

    private Singleton_2() {}

    public static Singleton_2 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {}
            instance = new Singleton_2();
            return instance;
        }
        return instance;
    }
}
