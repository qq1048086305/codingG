package com.example.coding.数组型线段树;

import java.io.*;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 16:58
 * @Version 1.0
 * @description:
 */
public class 单点处理线段树 {
    //https://www.luogu.com.cn/blog/50138/solution-p4588
    static int MAXN=1000001;
    //懒标记
    //多了个乘法标记
    static int mod=571373;
    static long n,m,a[]=new long[MAXN],ans[]=new long[MAXN<<2];
    static BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out=new PrintWriter(System.out);
    static int left(int x)
    {
        return x<<1;
    }
    static int right(int x)
    {
        return x<<1|1;
    }
    static void push_up(int p)
    {
        ans[p]=(ans[left(p)]*ans[right(p)])%mod;
    }
    static void build(int p,int l,int r)
    {
        if(l==r){
            ans[p]=1;
            return;
        }
        int mid=(l+r)>>1;
        build(left(p),l,mid);
        build(right(p),mid+1,r);
        push_up(p);
    }
    static void update(int p,int l,int r,int q_x,int q_y,int k)
    {
        if(q_x<=l&&r<=q_y)
        {
           ans[p]=k%mod;
            return ;
        }
        int mid=(l+r)>>1;
        if(q_x<=mid)update(left(p),l,mid,q_x,q_y,k);
        if(q_y>mid) update(right(p),mid+1,r,q_x,q_y,k);
        push_up(p);
    }
    public static void main(String[] args) throws IOException {
        n=Integer.parseInt(sc.readLine().trim());
        while (n-->0){
            String s[]=sc.readLine().split("\\s+");
            m=Integer.parseInt(s[0]);
            mod=Integer.parseInt(s[1]);
            build(1,1, (int) m);
            for(int i=1;i<=m;i++)
            {   int a1,b;
                String[] split = sc.readLine().split("\\s+");
                a1=Integer.parseInt(split[0]);
                switch(a1)
                {
                    case 1:{
                        b=Integer.parseInt(split[1]);
                        //g-h 乘上i
                        update(1,1, (int) m,i,i,b);
                        out.println(ans[1]%mod);
                        break;
                    }
                    case 2:{
                        b=Integer.parseInt(split[1]);
                        update(1,1, (int) m, b,b,1);
                        out.println(ans[1]%mod);
                        break;
                    }
                }
            }
        }
        out.flush();
    }
}
