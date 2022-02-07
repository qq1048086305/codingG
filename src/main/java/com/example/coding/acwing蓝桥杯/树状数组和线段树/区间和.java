package com.example.coding.acwing蓝桥杯.树状数组和线段树;

/**
 * @Author 神様だよ
 * @Date 2021/12/19 10:05
 * @Version 1.0
 * @description:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 区间和 {
    static int N = 100010;
    static int n;
    static int m;
    static int[] a = new int[N];
    static int[] tr = new int[N];

    public static int lowbit(int x)
    {
        return x & -x;
    }
    //在x位置加上v，并将后面相关联的位置也加上v
    public static void add(int x,int v)
    {
        for(int i = x;i <= n;i += lowbit(i)) tr[i] += v;
    }
    //前缀和
    public static int query(int x)
    {
        int res = 0;
        for(int i = x;i >= 1;i -= lowbit(i)) res += tr[i];
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = reader.readLine().split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        String[] s2 = reader.readLine().split(" ");
        for(int i = 1;i <= n;i++) a[i] = Integer.parseInt(s2[i - 1]);
        //搭建树状数组
        for(int i = 1;i <= n;i++) add(i,a[i]);

        while(m -- > 0)
        {
            String[] s3 = reader.readLine().split(" ");
            int k = Integer.parseInt(s3[0]);
            int x = Integer.parseInt(s3[1]);
            int y = Integer.parseInt(s3[2]);
            //k = 0 是询问[x,y]的区间和，k = 1是在x位置添加y元素
            if(k == 0) System.out.println(query(y) - query(x - 1));
            else add(x,y);
        }
    }
}