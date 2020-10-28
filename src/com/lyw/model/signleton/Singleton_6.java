package com.lyw.model.signleton;

/**
 * 不仅可以解决线程同步， 还可以防止反序列化
 *
 * @author lyw
 * @date 2020/10/28 21:22
 */
public enum Singleton_6 {

    INSTANCE;

    public static Singleton_6 getInstance() {
        return Singleton_6.INSTANCE;
    }
}
