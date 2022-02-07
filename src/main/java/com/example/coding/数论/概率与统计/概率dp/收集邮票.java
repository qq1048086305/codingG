package com.example.coding.数论.概率与统计.概率dp;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/29 17:09
 * @Version 1.0
 * @description:
 */
public class 收集邮票 {
    //https://www.luogu.com.cn/blog/league/solution-p4550
    static int n;
    static double f[]=new double[10005],g[]=new double[10005];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=n-1;i>=0;--i) {
            f[i]=f[i+1]+(1.0*n)/(1.0*(n-i));
            g[i]=(1.0*i)/(1.0*(n-i))*(f[i]+1)+g[i+1]+f[i+1]+1;
        }
        System.out.printf("%.2f\n",g[0]);

    }
}
