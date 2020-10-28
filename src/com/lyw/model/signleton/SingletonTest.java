package com.lyw.model.signleton;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lyw
 * @date 2020/10/28 20:26
 */
public class SingletonTest {
    public static void main(String[] args) {
        Set<Singleton_6> set = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                Singleton_6 instance = Singleton_6.getInstance();
                System.err.println(instance);
                set.add(instance);
            }).start();
        }
        System.err.println("set.size:" + set.size());
    }
}
