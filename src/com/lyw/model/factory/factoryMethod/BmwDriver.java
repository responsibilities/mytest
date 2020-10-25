package com.lyw.model.factory.factoryMethod;

import com.lyw.model.factory.SimpleFactory.Bmw;
import com.lyw.model.factory.SimpleFactory.Car;

/**
 * 工厂类角色
 *
 * @author lyw
 * @date 2020/10/15 23:13
 */
public class BmwDriver implements Driver_2 {

    @Override
    public Car driverCar() {
        return new Bmw();
    }
}
