package com.example.coding.数论.扩展欧几里得原理;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 8:57
 * @Version 1.0
 * @description:
 */
public class 青蛙的约会 {
    //https://www.luogu.com.cn/blog/chenleyu/solution-p1516
    static long ans,x1,y1;

    static long exgcd(long a,long b)
    {
        if(b==0)
        {
            x1=1;
            y1=0;
            return a;
        }
        ans=exgcd(b,a%b);
        long t=x1;
        x1=y1;
        y1=t-a/b*y1;
        return ans;
    }

    public static void main(String[] args) {
        long n,m,x,y,l;
        Scanner sc=new Scanner(System.in);
        x=sc.nextLong();
        y=sc.nextLong();
        m=sc.nextLong();
        n=sc.nextLong();
        l=sc.nextLong();
        PrintWriter cout=new PrintWriter(System.out);
        long b=n-m,a=x-y;
        if(b<0)
        {
            b=-b;
            a=-a;
        }//处理负数
        exgcd(b,l);
        if(a%ans!=0)//判断方程有无解。  =1有解 扩欧
            cout.print("Impossible");
        else
            cout.print(((x1*(a/ans))%(l/ans)+(l/ans))%(l/ans));//处理负数
        cout.close();
    }
}
