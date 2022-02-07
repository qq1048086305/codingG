package com.example.coding.数论.最大公约数欧几里得和最小公倍数;

/**
 * @Author 神様だよ
 * @Date 2021/11/18 10:00
 * @Version 1.0
 * @description:
 */


import java.util.Scanner;

public class 添加括号{
    //https://www.luogu.com.cn/blog/user25426/solution-p2651
    static int MAXN=(int)1e5+10;
    static long LL;
    static int t,n;
    static long a[]=new long[MAXN];
    static long gcd(long a,long b)
    {
        return b==0?a:gcd(b,a%b);
    }

    public static void  main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        while(t-->0)
        {
            n=sc.nextInt();
            for(int i=1;i<=n;i++) a[i]=sc.nextLong();
            for(int i=1;i<=n;i++)
            {
                if(i==2) continue;//特别注意过滤a2!!!
                a[2]=a[2]/gcd(a[2],a[i]);//约分
            }
            if(a[2]==1) System.out.printf("Yes\n");
            else System.out.printf("No\n");
        }
    }
}
