package com.example.设计模式.创建者模式.单例模式;

/**
 * @Author 神様だよ
 * @Date 2021/12/11 15:18
 * @Version 1.0
 * @description:
 */
public class Singleton2 {
    private static Singleton2 singleton;
    static {
        singleton=new Singleton2();
    }
    public Singleton2 getSingleton(){
        return this.singleton;
    }
}
