package com.example.coding.数组型线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 15:00
 * @Version 1.0
 * @description:
 */
public class 线段树2 {
    static int MAXN=1000001;
    //懒标记
    //多了个乘法标记
    static int mod=571373;
    static long n,m,a[]=new long[MAXN],ans[]=new long[MAXN<<2];
    static int add[]=new int[MAXN<<2];
    static int mul[]=new int[MAXN<<2];
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
        ans[p]=(ans[left(p)]%mod+ans[right(p)]%mod)%mod;
    }
    static void build(int p,int l,int r)
    {
        if(l==r){
            ans[p]=a[l]%mod;
            return;
        }
        int mid=(l+r)>>1;
        build(left(p),l,mid);
        build(right(p),mid+1,r);
        push_up(p);
    }
    static void f(int p,int l,int r,int k)
    {
        add[p]=(add[p]+k)%mod;
        ans[p]=(ans[p]+k*(r-l+1))%mod;

    }
    static void push_down(int p,int l,int r)
    {
        int mid=(l+r)>>1;
        //f(left(p),l,mid,add[p]);
        //f(right(p),mid+1,r,add[p]);
        add[p]=0;
    }
    static void update(int nl,int nr,int l,int r,int p,int k)
    {
        if(nl<=l&&r<=nr)
        {
            ans[p]=(ans[p]+k*(r-l+1))%mod;
            add[p]=(add[p]+k)%mod;
            return ;
        }
        if(mul[p]!=1||add[p]!=0){
            push_down_mul(p,l,r);
        }
        int mid=(l+r)>>1;
        if(nl<=mid)update(nl,nr,l,mid,left(p),k);
        if(nr>mid) update(nl,nr,mid+1,r,right(p),k);
        push_up(p);
    }
    static long query(int q_x,int q_y,int l,int r,int p)
    {
        long res=0;
        if(q_x<=l&&r<=q_y)return ans[p]%mod;
        int mid=(l+r)>>1;
        if(mul[p]!=1||add[p]!=0){
            push_down_mul(p,l,r);
        }
        if(q_x<=mid)res+=query(q_x,q_y,l,mid,left(p));
        if(q_y>mid) res+=query(q_x,q_y,mid+1,r,right(p));
        //push_up(p);
        return res%mod;
    }

    public static void main(String[] args) throws IOException {
        int a1,b,c,d,e,f;
        String s[]=sc.readLine().split("\\s+");
        n=Integer.parseInt(s[0]);
        Arrays.fill(mul,1);
        m=Integer.parseInt(s[1]);
        mod=Integer.parseInt(s[2]);
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
                    int g,h,i;
                    g=Integer.parseInt(split[1]);
                    h=Integer.parseInt(split[2]);
                    i=Integer.parseInt(split[3]);
                    //g-h 乘上i
                    multiple(g,h,1, (int) n,1,i);
                    break;
                }
                case 2:{
                    b=Integer.parseInt(split[1]);
                    c=Integer.parseInt(split[2]);
                    d=Integer.parseInt(split[3]);
                    update(b,c,1, (int) n,1,d);
                    break;
                }
                case 3:{
                    e=Integer.parseInt(split[1]);
                    f=Integer.parseInt(split[2]);
                    System.out.printf("%d\n",query(e,f,1, (int) n,1));
                    break;
                }
            }
        }
    }

    static void multiple(int nl,int nr,int l,int r,int p,int k) {
        if(nl<=l&&r<=nr)
        {
            ans[p]=(ans[p]*k)%mod;
            add[p]=(add[p]*k)%mod;
            mul[p]=(mul[p]*k)%mod;
            return ;
        }
        if(mul[p]!=1||add[p]!=0){
            push_down_mul(p,l,r);
        }
        int mid=(l+r)>>1;
        if(nl<=mid)multiple(nl,nr,l,mid,left(p),k);
        if(nr>mid) multiple(nl,nr,mid+1,r,right(p),k);
        push_up(p);
    }

    static void push_down_mul(int p, int l, int r) {
        int lson=left(p);
        int rson=right(p);
        int mid=(l+r)>>1;
        mul[lson]=(mul[lson]*mul[p])%mod;
        mul[rson]=(mul[rson]*mul[p])%mod;
        add[lson]=(add[lson]*mul[p])%mod;
        add[rson]=(add[rson]*mul[p])%mod;
        ans[lson]=(ans[lson]*mul[p])%mod;
        ans[rson]=(ans[rson]*mul[p])%mod;
        mul[p]=1;
        add[lson]=(add[lson]+add[p])%mod;
        add[rson]=(add[rson]+add[p])%mod;
        ans[lson]=(ans[lson]+(mid-l+1)*add[p])%mod;
        ans[rson]=(ans[rson]+(r-mid)*add[p])%mod;
        add[p]=0;
    }
}
