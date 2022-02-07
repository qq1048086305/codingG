package com.example.coding.前缀和与差分;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 14:08
 * @Version 1.0
 * @description:
 */
public class 最大连续字段和二维压缩版 {
    static int n;
    static int a[][]=new int[130][130];//存储题目中的矩阵
    static int sum[][]=new int[130][130];
    static int qz[][]=new int[130][130];//qz[i][j]指的是第i行到j的前缀和
    //二维前缀和的变形
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                a[i][j]=sc.nextInt();
                qz[i][j]=qz[i][j-1]+a[i][j];//求前缀和
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+a[i][j];//计算sum
            }
        }
        int mx=-99999999;//存储答案
        //枚举所有子矩阵
        for(int x1=1;x1<=n;x1++){
            for(int y1=1;y1<=n;y1++){
                for(int x2=1;x2<=n;x2++){
                    for(int y2=1;y2<=n;y2++){
                        if(x2<x1 || y2<y1) continue;//如果左上角比右下角还要大，就不用求了，下一个
                        mx=Math.max(mx,sum[x2][y2]+sum[x1-1][y1-1]-sum[x2][y1-1]-sum[x1-1][y2]);//求最大值
                    }
                }
            }
        }
        System.out.println(mx);
    }
}
