package com.example.coding.刷题.水题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 22:52
 * @Version 1.0
 * @description:
 */
public class 登录金币 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a,b,c;
        a=sc.nextInt();//登录金币
        b=sc.nextInt();//连续七天金币
        c=sc.nextInt();//目标金币
        int cur=0;
        int count=0;
        while (cur<c){
            cur+=a;
            count++;
            if(count%7==0){
                cur+=b;
            }
        }
        System.out.println(count);
    }
}
