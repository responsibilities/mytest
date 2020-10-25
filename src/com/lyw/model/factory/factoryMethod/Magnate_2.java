package com.lyw.model.factory.factoryMethod;

import com.lyw.model.factory.SimpleFactory.Car;

/**
 * 应该和具体产品形成对应关系
 *
 * @author lyw
 * @date 2020/10/15 23:19
 */
public class Magnate_2 {

    public static void main(String[] args) {
        Driver_2 driver_2 = new BenzDriver();
        Car car = driver_2.driverCar();
        car.drive();
    }
}
