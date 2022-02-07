package com.example.coding.数论.快速幂;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 8:49
 * @Version 1.0
 * @description:
 */
public class 快速幂 {
    static  long mod;
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

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        long a,b;
        a=sc.nextLong();
        b=sc.nextLong();
        mod=sc.nextLong();
        out.printf("%d^%d mod %d=%d",a,b,mod,quick_pow(a,b));
        out.close();
    }
}
