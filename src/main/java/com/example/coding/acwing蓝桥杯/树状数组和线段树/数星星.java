package com.example.coding.acwing蓝桥杯.树状数组和线段树;

/**
 * @Author 神様だよ
 * @Date 2021/12/19 10:04
 * @Version 1.0
 * @description:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 数星星{
    static int N = 32010;
    static int[] a = new int[N];
    static int[] tr = new int[N];
    static int n;
    static int[] level = new int[N];
    static int lowbit(int x)
    {
        return x & -x;
    }
    static void add(int x,int v)
    {
        for(int i = x;i < N;i += lowbit(i)) tr[i] += v;
    }
    static int query(int x)
    {
        int res = 0;
        for(int i = x;i >= 1;i -= lowbit(i)) res += tr[i];
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine().trim());
        for(int i = 0;i < n;i++)
        {
            String[] s1 = reader.readLine().split(" ");
            int x = Integer.parseInt(s1[0]) + 1;
            int y = Integer.parseInt(s1[1]);
            level[query(x)] ++;
            add(x,1);
        }
        for(int i = 0;i < n;i++) System.out.println(level[i]);
    }
}