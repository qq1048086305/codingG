package com.example.设计模式.创建者模式.单例模式;

/**
 * @Author 神様だよ
 * @Date 2021/12/11 15:15
 * @Version 1.0
 * @description:
 */
//单例模式
public class Singleton {
    private static Singleton singleton=new Singleton();
    //对外提供
    public Singleton getSingleton(){
        return this.singleton;
    }
    /**
     *该方式在成员位置声明Singleton类型的静态变量，
     * 并创建Singleton类的对象instance。
     * instance对象是随着类的加载而创建的。如果该对象足够大的话，而一直没有使用就会造成内存的浪费。
     */

}
