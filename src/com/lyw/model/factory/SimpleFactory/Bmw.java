package com.lyw.model.factory.SimpleFactory;

/**
 * 具体产品角色
 * @author lyw
 * @date 2020/10/15 22:33
 */
public class Bmw implements Car {

    /**
     * 开车
     */
    @Override
    public void drive() {
        System.err.println("drive bmw");
    }
}
