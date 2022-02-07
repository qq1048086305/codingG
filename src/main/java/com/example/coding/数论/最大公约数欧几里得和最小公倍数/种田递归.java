package com.example.coding.数论.最大公约数欧几里得和最小公倍数;

/**
 * @Author 神様だよ
 * @Date 2021/11/18 10:04
 * @Version 1.0
 * @description:
 */


import java.util.Scanner;

public class 种田递归 {
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
    {   Scanner sc=new Scanner(System.in);
        long x,y;
        x=sc.nextLong();
        y=sc.nextLong();
        dfs(x,y);
        System.out.println(sum);
    }
    static long sum=0;              					//利用全局变量统计使用的力气
    static void dfs(long  x,long  y)    			 				 	 			//递归函数部分（请忽略这个鬼畜的函数名）   x，y分别代表矩形的长和宽
    {
        long minn,maxn;						//maxn,mann分别代表x，y中较长边和较短边，便于贪心
        if(x==y)
        {
            sum+=x*4;
            return;
        }									//递归边界1：x与y相等，即剩下的是个正方形，可以一次犁完；return结束递归
        else
        {
            minn=x<y?x:y;
            maxn=x>y?x:y;
            //sum+=minn*4;
            //dfs(minn,maxn-minn);			//这里就是调用递归了，先确定maxn和minn，然后以较小边为正方形的边犁完一块田（贪心），剩下的maxn变为maxn-minn，递归
            sum+=minn*4*(maxn/minn);    		//注意，这里多加了一个maxn/minn！整除运算的性质是向下取整，在题目当中就是重复把边长为minn的正方形犁完。
            if(maxn%minn==0)					//递归边界2：如果maxn是minn的整数倍，那么重复犁几个相同的正方形就行了。
                return;
            dfs(minn,maxn%minn);				//同时由—号改为%，求剩下的田的短边
        }
    }
}

