package com.example.coding.数论.概率论;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 9:20
 * @Version 1.0
 * @description:
 */
public class 越狱 {
    //https://www.luogu.com.cn/blog/104000/solution-p3197
    static int MOD=100003;
    static long qpow(long a,long p){
        long ans =1;
        while(p>0){
            if((p&1)==1) ans =ans *a %MOD;
            a =a *a %MOD;
            p >>=1;
        }	return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        long m,n;
        m=sc.nextLong();
        n=sc.nextLong();
        long ans =qpow(m,n) -m*qpow(m-1,n-1)%MOD;
        //+MOD防止负数
        out.printf("%d",(ans+MOD)%MOD);
        out.close();
    }

}
