package com.example.设计模式.创建者模式.单例模式;

/**
 * @Author 神様だよ
 * @Date 2021/12/11 15:22
 * @Version 1.0
 * @description:
 */
public class Singleton3 {
    private static volatile Singleton3 singleton3;//防止指令重排
    public  Singleton3 getSingleton(){
        if(singleton3==null){
            synchronized (Singleton3.class){
                if(singleton3==null){
                    //抢到锁之后再次判断是否为null,防止重复创建
                    singleton3=new Singleton3();
                }else{
                    return singleton3;
                }
            }

        }
        return singleton3;
    }
}
