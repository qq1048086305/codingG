package com.example.coding.数组型线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 15:00
 * @Version 1.0
 * @description:
 */
public class 线段树1 {
    static int MAXN=1000001;
    //懒标记
    static long n,m,a[]=new long[MAXN],ans[]=new long[MAXN<<2];
    static int tag[]=new int[MAXN<<2];
    static BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
    static int left(int x)
    {
        return x<<1;
    }
    static int right(int x)
    {
        return x<<1|1;
    }
    static void scan() throws IOException {

    }
    static void push_up(int p)
    {
        ans[p]=ans[left(p)]+ans[right(p)];
    }
    static void build(int p,int l,int r)
    {
        if(l==r){
            ans[p]=a[l];
            return;
        }
        int mid=(l+r)>>1;
        build(left(p),l,mid);
        build(right(p),mid+1,r);
        push_up(p);
    }
    static void f(int p,int l,int r,int k)
    {
        tag[p]=tag[p]+k;
        ans[p]=ans[p]+k*(r-l+1);
    }
    static void push_down(int p,int l,int r)
    {
        int mid=(l+r)>>1;
        f(left(p),l,mid,tag[p]);
        f(right(p),mid+1,r,tag[p]);
        tag[p]=0;
    }
    static void update(int nl,int nr,int l,int r,int p,int k)
    {
        if(nl<=l&&r<=nr)
        {
            ans[p]+=k*(r-l+1);
            tag[p]+=k;
            return ;
        }
        push_down(p,l,r);
        int mid=(l+r)>>1;
        if(nl<=mid)update(nl,nr,l,mid,left(p),k);
        if(nr>mid) update(nl,nr,mid+1,r,right(p),k);
        push_up(p);
    }
    static long query(int q_x,int q_y,int l,int r,int p)
    {
        long res=0;
        if(q_x<=l&&r<=q_y)return ans[p];
        int mid=(l+r)>>1;
        push_down(p,l,r);
        if(q_x<=mid)res+=query(q_x,q_y,l,mid,left(p));
        if(q_y>mid) res+=query(q_x,q_y,mid+1,r,right(p));
        return res;
    }

    public static void main(String[] args) throws IOException {
        int a1,b,c,d,e,f;
        String s[]=sc.readLine().split("\\s+");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        String[] split2 = sc.readLine().split("\\s+");
        for(int i=1;i<=n;i++){
            a[i]=Integer.parseInt(split2[i-1]);
        }
        build(1,1, (int) n);
        while(m-->0)
        {
            String[] split = sc.readLine().split("\\s+");
            a1=Integer.parseInt(split[0]);
            switch(a1)
            {
                case 1:{
                    b=Integer.parseInt(split[1]);
                    c=Integer.parseInt(split[2]);
                    d=Integer.parseInt(split[3]);
                    update(b,c,1, (int) n,1,d);
                    break;
                }
                case 2:{
                    e=Integer.parseInt(split[1]);
                    f=Integer.parseInt(split[2]);
                    System.out.printf("%d\n",query(e,f,1, (int) n,1));
                    break;
                }
            }
        }
    }
}
