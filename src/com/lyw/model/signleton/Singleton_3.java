package com.lyw.model.signleton;

/**
 * @author lyw
 * @date 2020/10/28 20:59
 */
public class Singleton_3 {
    private static Singleton_3 instance = null;

    private Singleton_3() {
    }

    public static Singleton_3 getInstance() {
        synchronized (Singleton_3.class) {
            if (instance == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                instance = new Singleton_3();
            }
            return instance;
        }
    }
}
