package com.example.coding.数论.排列组合.错误排序;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/25 14:34
 * @Version 1.0
 * @description:
 */
public class 信封问题 {
    //https://www.luogu.com.cn/problem/P1595
    //https://www.luogu.com.cn/blog/YoungNeal/solution-p1595
    //记住错排公式即可 递推 d[0]=0; d[1]=1;
    static int f[]=new int[25],n;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        f[1]=0;f[2]=1;f[3]=2;
        PrintWriter cout=new PrintWriter(System.out);
        if(n==1||n==2||n==3)
        {
            cout.printf("%d",f[n]);
            cout.close();
        }
        for(int i=4;i<=n;i++)
        {
            f[i]=(i-1)*(f[i-1]+f[i-2]);
        }
        cout.printf("%d",f[n]);
        cout.close();
    }
}
