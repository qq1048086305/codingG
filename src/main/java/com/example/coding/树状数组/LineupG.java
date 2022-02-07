package com.example.coding.树状数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 12:27
 * @Version 1.0
 * @description:
 */
public class
LineupG {
    //https://www.luogu.com.cn/blog/stonejuice/solution-p2880
    static int n, m;
    static int a[]=new int[50005] ,treex[]=new int[50005], treen[]=new int[50005];

    static int lowbit(int x)//求lowbit:2进制下末尾0的个数。可表示tree中包含数据数量
    {
        return x & -x;
    }

    static void _add(int x, int k)//建树QAQ
    {
        for(;x <= n; x += lowbit(x))
        {
            treex[x] = Math.max(treex[x], k);
            treen[x] = Math.min(treen[x], k);
        }
    }

    static int _findmax(int x, int y)//区间查询最大值
    {
        if(y > x)
        {
            if(y - lowbit(y) > x) return Math.max(treex[y], _findmax(x, y - lowbit(y)));
            else return Math.max(treex[y], _findmax(x, y - 1));
        }
        return treex[x];
    }

    static int _findmin(int x, int y)//区间查询最小值
    {
        if(y > x)
        {
            if(y - lowbit(y) > x) return Math.min(treen[y], _findmin(x, y - lowbit(y)));
            else return Math.min(treen[y], _findmin(x, y - 1));
        }
        return treen[x];
    }

    public static void main(String[] args) throws IOException {
        Arrays.fill(treen, 0x3f3f3f3f);
        PrintWriter out=new PrintWriter(System.out);
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        for(int i = 1; i <= n; i ++)
        {
            a[i]=Integer.parseInt(sc.readLine().trim());
            _add(i, a[i]);
        }
        for(int i = 1; i <= m; i ++)
        {
            int l, r;
            s=sc.readLine().split(" ");
            l=Integer.parseInt(s[0]);
            r=Integer.parseInt(s[1]);
            out.println( _findmax(l, r) - _findmin(l, r));
        }
        out.flush();
    }
}
