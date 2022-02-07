package com.example.设计模式.结构型模式.代理模式.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author 神様だよ
 * @Date 2021/12/11 16:26
 * @Version 1.0
 * @description:
 */
public class ProxyF {
    TrainStation station=new TrainStation();
    public SellTickets getTickets(){
        SellTickets sellTickets=(SellTickets)Proxy.newProxyInstance(station.getClass().getClassLoader(), station.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代售点收取一定的服务费用(jdk动态代理)");
                Object invoke = method.invoke(station, args);
                return invoke ;
            }
        });
        return sellTickets;
    }
}
