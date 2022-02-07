package com.example.coding.AOJ刷题;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/3 12:34
 * @Version 1.0
 * @description:
 */
public class AOJ0583 {
    public static int gcd(int n,int m){
        if(m==0){
            return n;
        }
        return gcd(m,n%m);
    }
    //找出三个数公共最大公约数从1开始找到因数即可
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int x,y;
        x=sc.nextInt();
        y=sc.nextInt();
        int GCD=gcd(Math.max(x,y),Math.min(x,y));
        if(num==3){
           int z=sc.nextInt();
           GCD=gcd(Math.max(z,GCD),Math.min(GCD,z));
        }
        for(int i=1;i<=GCD;i++){
            if(GCD%i==0){
                System.out.println(i);
            }
        }
    }
}
