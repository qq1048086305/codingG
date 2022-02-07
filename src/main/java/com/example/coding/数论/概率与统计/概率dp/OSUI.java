package com.example.coding.数论.概率与统计.概率dp;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/29 17:05
 * @Version 1.0
 * @description:
 */
public class OSUI {
    static int maxn=111111;

    static int n;
    static double p[]=new double[maxn];
    static double x1[]=new double[maxn],x2[]=new double[maxn],ans[]=new double[maxn];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=n;i++)
            p[i]=sc.nextDouble();
        for(int i=1;i<=n;i++){
            x1[i]=(x1[i-1]+1)*p[i];
            x2[i]=(x2[i-1]+2*x1[i-1]+1)*p[i];
            ans[i]=ans[i-1]+(3*(x1[i-1]+x2[i-1])+1)*p[i];
        }
        System.out.printf("%.1f",ans[n]);
    }

}
