package com.example.coding.acwing蓝桥杯.二分;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 15:40
 * @Version 1.0
 * @description:
 */
public class 机器人跳跃问题 {
    static int N=(int)1e5+10;
    static int h[]=new int[N],n;

    static boolean check(int mid)//判定能量是否够用
    {
        for(int i=1;i<=n;i++)
        {
            mid =2 * mid - h[i];
            if(mid<0) return false;
            else if(mid >= 1e5) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1; i<=n; i++){
            h[i]=sc.nextInt();
        }

        int i= 0,j=(int) 1e5;//二分边界
        while(i<j)
        {
            int mid = i + j >> 1;
            if(check(mid))j = mid;
            else i = mid + 1;
        }
        System.out.println(j);
    }
}
