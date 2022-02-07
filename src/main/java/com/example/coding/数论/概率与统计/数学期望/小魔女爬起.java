package com.example.coding.数论.概率与统计.数学期望;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/29 16:21
 * @Version 1.0
 * @description:
 */
public class 小魔女爬起 {

    static double a[]=new double[8],ans=1,sum;
    //https://www.luogu.com.cn/blog/Alansp/solution-p3802
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(int i=1;i<=7;i++) {
            a[i]=sc.nextDouble();
            sum+=a[i];
        }
        for(int i=1;i<=6;i++)
        {
            ans*=a[i];
            ans/=(sum-i+1);
        }
        ans*=5040;
        ans*=a[7];
        System.out.printf("%.3f",ans);
    }
}
