package com.example.coding.线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 20:29
 * @Version 1.0
 * @description:
 */
public class XOR的艺术 {
    static int maxx=300020;
    static int n,m,p,l,r,a[]=new int[maxx];
    static char s[]=new char[maxx];
    static long add[]=new long[maxx<<2],sum[]=new long[maxx<<2];
    static void getup(int rt)//向上更新
    {
        sum[rt]=sum[rt<<1]+sum[rt<<1|1];
    }
    static void bulid(int l,int r,int rt)//建树
    {
        if(l==r)
        {
            sum[rt]=a[l];//赋值
            return ;
        }
        int mid=(l+r)>>1;
        bulid(l,mid,rt<<1);
        bulid(mid+1,r,rt<<1|1);
        getup(rt);
    }
    static void pushdown(int rt,int len)//传递tag
    {   /**
     如果对于一段区间，长度为len，有n个1，
     那么就有len-n个0。
     相应地，对这段区间异或1之后，它的1的个数就变成了len-n。
        **/
        if(add[rt]!=0)
        {
            add[rt<<1]^=1;
            add[rt<<1|1]^=1;
            //如果说区间长度并不能整除以2，那么就把除以二向下取整丢给左儿子，然后把剩下的丢给右儿子。
            sum[rt<<1]=(len-(len>>1))-sum[rt<<1];
            sum[rt<<1|1]=(len>>1)-sum[rt<<1|1];
            add[rt]=0;
        }
    }
    static long query(int L,int R,int l,int r,int rt)//分区间查询
    {//LR是要查询的区间，lr是给定的区间。update同理。
        if(l>=L&&r<=R)return sum[rt];
        pushdown(rt,r-l+1);
        int mid=(r+l)>>1;
        long tot=0;
        if(L<=mid) tot+=query(L,R,l,mid,rt<<1);
        if(mid+1<=R) tot+=query(L,R,mid+1,r,rt<<1|1);
        return tot;
    }
    static void update(int L,int R,int l,int r,int rt)//更新
    {
        pushdown(rt,r-l+1);
        if(l>=L&&r<=R)
        {
            add[rt]^=1;
            sum[rt]=r-l+1-sum[rt];
            return;
        }
        int mid=(l+r)>>1;
        if(L<=mid) update(L,R,l,mid,rt<<1);
        if(mid+1<=R) update(L,R,mid+1,r,rt<<1|1);
        getup(rt);
    }
    static public Integer getInt(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split(" ");
        PrintWriter out=new PrintWriter(System.out);
        n=getInt(s[0]);
        m=getInt(s[1]);
        String ss=sc.readLine();
        for(int i=1;i<=n;i++) a[i]=ss.charAt(i-1)-'0';//再转换成数字
        bulid(1,n,1);
        for(int i=1;i<=m;i++)
        {   s=sc.readLine().split(" ");
            p=getInt(s[0]);
            l=getInt(s[1]);
            r=getInt(s[2]);
            if(p==0)
                update(l,r,1,n,1);
            if(p==1)
                out.println(query(l,r,1,n,1));
        }
        out.flush();
    }
}
