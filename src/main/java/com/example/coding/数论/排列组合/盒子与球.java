package com.example.coding.数论.排列组合;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/25 11:31
 * @Version 1.0
 * @description:
 */
public class 盒子与球 {
    //https://www.luogu.com.cn/blog/hkxa/solution-p1287
    //组合数 两种情况 一个球占用一个盒子 一个球与其他球共用一个盒子
    static long f(int n, int m)
    {
        if (m <= 0 || n < m)//无效条件直接return 0
            return 0;
        if (n == m)//一个球对应一个 盒子种数位1
            return 1;
        else
            return f(n-1, m-1) + f(n-1, m) * m;//一个球占用一个盒子+一个球与其他球共用一个盒子
    }
    //排列数 m个盒子互不相同
    static long fac(int i) // 然而这个函数不用讲什么
    {
        if (i == 1)
            return 1;
        else
            return i * fac(i - 1);
    }

    public static void main(String[] args) {
        int n, m;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        //m个盒子互不相同
        System.out.println(f(n,m)*fac(m));
    }
}
