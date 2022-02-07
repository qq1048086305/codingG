package com.example.coding.刷题.水题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 15:12
 * @Version 1.0
 * @description:
 */
public class Mode数组 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        int a[]=new int[105];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            a[x]++;
            max=Math.max(max,a[x]);
        }
        System.out.println(max);
    }
}
