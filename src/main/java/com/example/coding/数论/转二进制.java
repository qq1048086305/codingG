package com.example.coding.数论;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/11/23 8:42
 * @Version 1.0
 * @description:
 */
public class 转二进制 {
    static char z[]={'0','1'};
    /**
     * 例如在C++里，-15%-2=-1，-15/-2=7,而7*-2+（-1）=-15
     *
     * 但是因为我们是不断取余数倒序为转换结果，所以余数不能出现负数，那怎么办呢？
     * @param n
     * @param m
     */
    //被除数=商*除数+余数，
    //处理余数为负数的方法
    //（商+1）*除数+（余数-除数）=商*除数+除数+余数-除数=商*除数+余数=被除数
    static void zhuan(int n,int m){//printf("n:%d m:%d",n,m);
        if(n==0)return;
        else{
            if(n>0||n%m==0){zhuan(n/m,m); System.out.printf("%c",z[n%m]);return;}
            else {zhuan(n/m+1,m); System.out.printf("%c",z[n%m-m]); return;}
        }
    }
    static List<Integer> list=new ArrayList<>();
    public static void toBinary(int n,int m){
        if(n==0){
            return;
        }
        if(n>0||n%m==0){
            toBinary(n/m,m);
            list.add(z[n%m]-'0');
            return;
        }
    }
    public static void main(String[] args) {
        toBinary(4,2);
        System.out.println(list);
    }
}
