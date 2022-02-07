package com.example.coding.树状数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 8:55
 * @Version 1.0
 * @description:
 */
public class 树状数组2 {
    static int n,m;
    static int arr[]=new int[500010];
    static int tree[]=new int[500010];
    static int lowbit(int x)
    {
        return x & -x;
    }
    static void add(int x,int k)
    {
        while(x<=n)
        {
            tree[x]+=k;
            x+=lowbit(x);
        }
    }
    static int search(int x)
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
            arr[i]=Integer.parseInt(split[i-1]);
        for(int i=1;i<=m;i++)
        {
            int a;
            split=sc.readLine().split(" ");
            a=Integer.parseInt(split[0]);
            if(a==1)
            {
                int x,y,z;
                x=Integer.parseInt(split[1]);
                y=Integer.parseInt(split[2]);
                z=Integer.parseInt(split[3]);
                add(x,z);
                add(y+1,-z);
            }
            if(a==2)
            {
                int x;
                x=Integer.parseInt(split[1]);
                out.printf("%d\n",arr[x]+search(x));
            }
        }
        out.flush();;
    }
}
