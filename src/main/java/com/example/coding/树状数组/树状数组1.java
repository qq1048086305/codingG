package com.example.coding.树状数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 20:39
 * @Version 1.0
 * @description:
 */
public class 树状数组1 {
    //https://www.luogu.com.cn/blog/TJor/xian-duan-shu-yu-shu-zhuang-shuo-zu
    static int n,m,tree[]=new int[2000010];
    static int lowbit(int k)
    {
        return k & -k;
    }
    static void add(int x,int k)
    {
        while(x<=n)
        {
            tree[x]+=k;
            x+=lowbit(x);
        }
    }
    static int sum(int x)
    {
        int ans=0;
        while(x!=0)
        {
            ans+=tree[x];
            x-=lowbit(x);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String[] split = sc.readLine().split(" ");
        n=Integer.parseInt(split[0]);
        PrintWriter out=new PrintWriter(System.out);
        m=Integer.parseInt(split[1]);
        split=sc.readLine().split(" ");
        for(int i=1;i<=n;i++)
        {
            int a;
            a=Integer.parseInt(split[i-1]);
            add(i,a);
        }
        for(int i=1;i<=m;i++)
        {
            int a,b,c;
            split=sc.readLine().split(" ");
            a=Integer.parseInt(split[0]);
            b=Integer.parseInt(split[1]);
            c=Integer.parseInt(split[2]);
            if(a==1)
                add(b,c);
            if(a==2)
                out.println(sum(c)-sum(b-1));
        }
        out.flush();
    }
}
