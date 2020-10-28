package com.lyw.model.signleton;

/**
 * DCL: double checkout lock
 * @author lyw
 * @date 2020/10/28 21:16
 */
public class Singleton_4 {

    private static Singleton_4 instance = null;

    private Singleton_4() {
    }

    public static Singleton_4 getInstance() {
        if (instance == null) {
            synchronized (Singleton_4.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                if (instance == null) {
                    instance = new Singleton_4();
                }
            }
        }
        return instance;
    }
}
