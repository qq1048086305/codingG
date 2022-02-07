package com.example.coding.树状数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 9:35
 * @Version 1.0
 * @description:
 */
public class MootFestG {
    //https://www.luogu.com.cn/blog/NEXUSS/solution-p2345
    static long wz[]=new long[20010],yy[]=new long[20010],mn=20000;
    static int n;
    static long ans;
    static class Node implements Comparable<Node>{
         long xi;
         long vi;

        @Override
        public int compareTo(Node o) {
            return (int)(this.vi-o.vi);
        }
    }
    static Node a[]=new Node[20010];
    static int lowbit(int x) {	return x&(-x);}
    static void crwz(int x) { for(;x<=mn;x+=lowbit(x)) wz[x]++;}
    static int z(int x)
    {
        int sum=0;
        for(;x>=1;x-=lowbit(x)) sum+=wz[x];
        return sum;
    }
    static void cryy(int x,int v) { for(;x<=mn;x+=lowbit(x)) yy[x]+=v;}
    static int y(int x)
    {
        int sum=0;
        for(;x>=1;x-=lowbit(x)) sum+=yy[x];
        return sum;
    }
    static int jdz(int x)
    {
        if(x<0) return -x;
        else return x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        String s[];
        for(int i=1;i<=n;++i) {
            s=sc.readLine().split(" ");
            a[i]=new Node();
            a[i].vi=Long.parseLong(s[0]);
            a[i].xi=Long.parseLong(s[1]);
        }
        Arrays.sort(a,1,1+n);
        for(int i=1;i<=n;++i)
        {
            int j=(int)a[i].xi;
            ans+=a[i].vi*(z(j-1)*j-y(j-1)+y((int)mn)-y(j)-(z((int)mn)-z(j))*j);
            crwz((int)a[i].xi);
            cryy(j,(int)a[i].xi);
        }
        System.out.printf("%d",ans);
    }
}
