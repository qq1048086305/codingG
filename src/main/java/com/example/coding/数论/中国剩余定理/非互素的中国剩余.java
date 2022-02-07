package com.example.coding.数论.中国剩余定理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 21:10
 * @Version 1.0
 * @description:
 */
public class 非互素的中国剩余 {
    //https://www.luogu.com.cn/blog/KingSann/solution-p4777
    static int maxn=100010;
    static int n;
    static long ai[]=new long[maxn],bi[]=new long[maxn];

    static long mul(long a,long b,long mod)
    {
        long res=0;
        while(b>0)
        {
            if((b&1)==1) res=(res+a)%mod;
            a=(a+a)%mod;
            b>>=1;
        }
        return res;
    }
    static long x,y;
    static long exgcd(long a,long b)
    {
        if(b==0){x=1;y=0;return a;}
        long gcd=exgcd(b,a%b);
        long tp=x;
        x=y;
        y=tp-a/b*y;
        return gcd;
    }

    static long excrt()
    {
        long M=bi[1],ans=ai[1];//第一个方程的解特判
        for(int i=2;i<=n;i++)
        {
            long a=M,b=bi[i],c=(ai[i]-ans%b+b)%b;//ax≡c(mod b)
            long gcd=exgcd(a,b),bg=b/gcd;
            if(c%gcd!=0) return -1; //判断是否无解，然而这题其实不用
            x=mul(x,c/gcd,bg);
            ans+=x*M;//更新前k个方程组的答案
            M*=bg;//M为前k个m的lcm
            ans=(ans%M+M)%M;
        }
        return (ans%M+M)%M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        PrintWriter cout=new PrintWriter(System.out);
        for(int i=1;i<=n;++i){
            String s[]=sc.readLine().split(" ");
            bi[i]=Long.parseLong(s[0]);
            ai[i]=Long.parseLong(s[1]);
        }
        cout.printf("%d",excrt());
        cout.close();
    }
}
