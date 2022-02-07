package com.example.设计模式.创建者模式.工厂模式;

/**
 * @version v1.0
 * @ClassName: DessertFactory
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public interface DessertFactory {

    //生产咖啡的功能
    Coffee createCoffee();

    //生产甜品的功能
    Dessert createDessert();
}
