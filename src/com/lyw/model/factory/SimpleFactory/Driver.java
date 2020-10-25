package com.lyw.model.factory.SimpleFactory;

/**
 * 工厂类角色
 *
 * @author lyw
 * @date 2020/10/15 22:33
 */
public class Driver {

    /**
     * 工厂方法，注意：返回类型为抽象产品类型
     */
    public static Car driverCar(String carName) throws Exception {
        if ("benz".equalsIgnoreCase(carName)) {
            return new Benz();
        } else if ("bmw".equalsIgnoreCase(carName)) {
            return new Bmw();
        } else {
            throw new Exception("Illegal carName:" + carName);
        }
    }
}
