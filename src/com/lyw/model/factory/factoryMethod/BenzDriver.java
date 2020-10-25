package com.lyw.model.factory.factoryMethod;


import com.lyw.model.factory.SimpleFactory.Benz;
import com.lyw.model.factory.SimpleFactory.Car;

/**
 * 工厂类角色
 *
 * @author lyw
 * @date 2020/10/15 23:02
 */
public class BenzDriver implements Driver_2 {


    @Override
    public Car driverCar() {
        return new Benz();
    }
}
