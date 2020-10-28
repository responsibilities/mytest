package com.lyw.model.signleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 * @author lyw
 * @date 2020/10/28 21:17
 */
public class Singleton_5 {
    private static Singleton_5 instance = null;

    private Singleton_5() {}

    private static class Singleton_5_Holder {
        private static final Singleton_5 INSTANCE = new Singleton_5();
    }

    public static Singleton_5 getInstance() {
        return Singleton_5_Holder.INSTANCE;
    }
}
