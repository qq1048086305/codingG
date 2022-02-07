package com.example.coding.数论.中国剩余定理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 17:19
 * @Version 1.0
 * @description:
 */
public class 猜数字 {
    static BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static long a[]=new long[20],b[]=new long[20];
    static long mod=11;
    static long x,y;
    static long quick_pow(long ml,long nl)//快速幂
    {
        long s=1;
        while(nl>0)
        {
            if(nl%2==1)
            {
                s=(s%mod)*(ml%mod)%mod;
            }
            ml=ml*ml%mod;
            nl=nl>>1;
        }
        return s%mod;
    }
    //快速乘
    static long quick_mul(long a,long b)
    {
        long ans=0;
        while(b>0)
        {
            if((b&1)==1) ans=(ans+a)%mod;
            a=(a+a)%mod;
            b>>=1;
        }
        return ans;
    }


    static void exgcd(long a,long b)
    {
        if(b==0){ x=1; y=0; return;}
        exgcd(b,a%b);
        long tp=x;
        x=y; y=tp-a/b*y;
    }
    static long china()
    {
        long ans=0,lcm=1;
        //中国剩余定理 最小公倍数
        for(int i=1;i<=k;++i) lcm*=b[i];
        mod=lcm;
        for(int i=1;i<=k;++i)
        {
            long tp=lcm/b[i];
            exgcd(tp,b[i]);
            //求出逆元
            x=(x%b[i]+b[i])%b[i];
            //找到模b[i]余1的数Mi乘Mi逆 乘余数倍
            ans=(ans+quick_mul(quick_mul(tp,x),a[i]))%lcm;//记得快速乘
        }
        return (ans+lcm)%lcm;
    }

    public static void main(String[] args) throws IOException {

        k=Integer.parseInt(sc.readLine());
        String s[]=sc.readLine().split(" ");
        for(int i=1;i<=k;++i) a[i]=Long.parseLong(s[i-1]);
        s=sc.readLine().split(" ");
        for(int i=1;i<=k;++i) b[i]=Long.parseLong(s[i-1]);
        for(int i=1;i<=k;i++) a[i]=(a[i]%b[i]+b[i])%b[i];
        System.out.println(china());
        //niiick
    }
}
