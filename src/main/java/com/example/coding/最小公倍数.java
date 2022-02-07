package com.example.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 11:11
 * @Version 1.0
 * @description:
 */
public class 最小公倍数 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        long a;
        int n;
        n= Integer.parseInt(sc.readLine().trim());
        String[] s = sc.readLine().split(" ");
        long num1=0;
        //从前往后一个一个求最小公倍数 相乘除最大公约数即可
        for(int i=0;i<n;i++){
            a=Long.parseLong(s[i]);
            if(i==0){
                num1=a;
            }else if(num1>a){
                long gcd=gcd(num1,a);
                num1=num1*a/gcd;
            }else {
                 long gcd=gcd(a,num1);
                 num1=num1*a/gcd;
            }
        }
        System.out.println(num1);
    }

    /**
     * 求最大公约数
     * @param x
     * @param y
     * @return
     */
    public static long gcd(long x,long y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }
}
