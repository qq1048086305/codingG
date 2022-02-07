package com.example.coding.二分搜索;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/14 12:11
 * @Version 1.0
 * @description:
 */
public class 小鸟的设备 {
    static int n;//设备数量
    static double p;//充电器的充电速度
    static double a[]=new double[200000],b[]=new double[200000];
    static double left=0,right=1e10;
    static double sum=0; //需要的能量总和（验证答案时）、所有设备的消耗能量速度总和（-1特判时）
    static boolean check(double ans){//验证答案
        double q=p*ans;//充电器最多提供的能量
        sum=0;
        for(int i=0;i<n;i++){
            if(a[i]*ans<=b[i]){//若设备已有的能量大于使用时间需要的能量
                continue;//忽略该设备
            }
            sum+=(a[i]*ans-b[i]);//否则用充电器充电，使设备已有的能量等于使用时间需要的能量，并记录需要的能量。
        }
        return sum<=q;//最后比较需要的能量总和和充电器最多提供的能量。
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        p=sc.nextInt();
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            b[i]=sc.nextInt();
            sum+=a[i];
        }
        if(sum<=p){//若所有设备的消耗能量速度总和还是小于充电器的充电速度，输出-1。
            System.out.println(-1.000000);
            return ;
        }
        while(right-left>1e-6){
            double mid=(left+right)/2;
            if(check(mid)){
                left=mid;

            }else{
                right=mid;
            }
        }
        System.out.println(left);
    }
}
