package com.lyw.model.factory.SimpleFactory;

/**
 * <p><b>引子</b>
 * 话说十年前，有一个暴发户，他家有三辆汽车——Benz 奔驰、Bmw 宝马、Audi 奥迪，
 * 还雇了司机为他开车。不过，暴发户坐车时总是怪怪的：上 Benz 车后跟司机说“开奔驰车！”，
 * 坐上 Bmw 后他说“开宝马车！”，坐上 Audi 说“开奥迪车！”。你一定说：这人有病！直接说
 * 开车不就行了？！
 * 而当把这个暴发户的行为放到我们程序设计中来时，会发现这是一个普遍存在的现象。
 * 幸运的是，这种有病的现象在 OO（面向对象）语言中可以避免了。下面就以 Java 语言为
 * 基础来引入我们本文的主题：工厂模式</p>
 * <p><b>分类</b>
 * 工厂模式主要是为创建对象提供过渡接口，以便将创建对象的具体过程屏蔽隔离起来，
 * 达到提高灵活性的目的。
 * 工厂模式在《Java 与模式》中分为三类：
 * <li>1）简单工厂模式（Simple Factory）</li>
 * <li>2）工厂方法模式（Factory Method）</li>
 * <li>3）抽象工厂模式（Abstract Factory）</li>
 * 这三种模式从上到下逐步抽象，并且更具一般性。
 * GOF 在《设计模式》一书中将工厂模式分为两类：工厂方法模式（Factory Method）与
 * 抽象工厂模式（Abstract Factory）。将简单工厂模式（Simple Factory）看为工厂方法模式的
 * 一种特例，两者归为一类。</p>
 * 欢迎暴发户出场
 * @author lyw
 * @date 2020/10/15 22:39
 */
public class Magnate {

    public static void main(String[] args) {
        try {
            // 告诉司机我今天要做奔驰
            Car car = Driver.driverCar("benz");
            car.drive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
