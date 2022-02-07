package com.example.coding.acwing蓝桥杯.DP.背包问题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 19:04
 * @Version 1.0
 * @description:
 */
public class 背包 {
    static int f[]=new int[1005];
    static int v[]=new int[1005];
    static int w[]=new int[1005];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        for(int i=0;i<n;i++){
            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=m;j>=v[i];j--){
                f[j]=Math.max(f[j-v[i]]+w[i],f[j]);
            }
        }
        System.out.println(f[m]);

    }
}
