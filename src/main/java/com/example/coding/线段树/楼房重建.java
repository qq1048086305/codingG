package com.example.coding.线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 19:39
 * @Version 1.0
 * @description:
 */
public class 楼房重建 {
    //https://www.luogu.com.cn/blog/tbr-blog/solution-p4198
    static int N=100000+10;
    static int n,m;
    static double a[]=new double[N];
    static double mx[]=new double[N*4];//区间最值
    static int len[]=new int[N*4];//区间长度
    static int query(int k,int l,int r,double maxx)
     //maxx表是我们要查询的值，也就是我们要查询的比该值斜率大的斜率的楼房数
    {
        if(mx[k]<=maxx)
        {
            return 0;
        }//如果这段区间的最大斜率比目前要查询的值大，那么显然对答案不会有影响，所以返回0
        if(l==r)
        {
            return mx[k]>maxx?1:0;
        }//如果是叶子节点，那么如果该点的斜率大于要查询的值就返回1，否则返回0
        else if(mx[k<<1]<=maxx)
        {
            return query(k<<1|1,((l+r)>>1)+1,r,maxx);
        }//如果左儿子的最大值小于等于查询值，就递归右儿子
        return query(k<<1,l,(l+r)>>1,maxx)+len[k]-len[k<<1];//否则递归左儿子,并且加上右儿子，因为是单调递增的,左儿子有一部分大了，那么右边肯定满足条件
    }
    static void change(int k,int l,int r,int ll,double v)
    {
        if(l==ll&&r==ll)
        {
            len[k]=1;
            mx[k]=v;
            return;
        }
        int mid=(l+r)>>1;
        if(ll<=mid) change(k<<1,l,mid,ll,v);
        else change(k<<1|1,mid+1,r,ll,v);
        mx[k]=Math.max(mx[k<<1],mx[k<<1|1]);
        //目前区间的最大值显然是左右区间的最大值的最大值
        len[k]=(len[k<<1]+query(k<<1|1,mid+1,r,mx[k<<1]));
        //该区间的答案是左区间的答案加上右区间的斜率大于左区间最大值的所有楼房
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split(" ");
        PrintWriter out=new PrintWriter(System.out);
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        int x,y;
        for(int i=1;i<=m;i++)
        {
            s=sc.readLine().split(" ");
            int l=Integer.parseInt(s[0]);
            int r=Integer.parseInt(s[1]);
            change(1,1,n,l,(double)r/l);
            out.printf("%d\n",len[1]);
        }
        out.flush();
    }
}
