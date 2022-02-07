package com.example.coding.数论.质因数分解;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/17 13:02
 * @Version 1.0
 * @description:
 */
public class 细胞分裂 {
    //https://www.luogu.com.cn/blog/2713840045cheng/post-di-di-er-pian-ti-xie-qiu-guo-post
    static int t=2147483647; //t的值为2147483647
    static class Node{
        int number,count;
    }
    static Node a[]=new Node[101];
    //top对应质因数总数
    static int m1,m2,n,top;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m1=sc.nextInt();
        m2=sc.nextInt();
        int x=m1;
        for(int i=0;i<101;i++){
            a[i]=new Node();
        }
        for(int i=2;i<=x;i++)
        {
            if(x%i==0)
            {
                a[++top].number=i;
                while(x%i==0)//分解质因数
                {
                    x/=i;
                    a[top].count++;//找出m1；
                }
                //m1对应质因数总数
                a[top].count*=m2;//试管总数
            }
        }
        int minn=t;
        for(int i=1;i<=n;i++)
        {   //找出所有细胞中满足条件 且分类出质因子的最小值即可
            int m;
            //细胞增长数
            m=sc.nextInt();
            boolean b=true;
            //去检验m1中所有质因数是否在m中全部包括
            for(int j=1;j<=top;j++)
                b=b&&(m%a[j].number==0);
            if(b)
            {
                int maxx=0;
                for(int j=1;j<=top;j++)
                {   //求一下这个质因子需多少秒 选出最大的就是最小耗费时间
                    int ans=0,mx=m;
                    while(mx%a[j].number==0)//分解质因数
                    {
                        mx/=a[j].number;
                        ans++;
                    }
                    ans=(a[j].count-1)/ans+1;
                    maxx=Math.max(maxx,ans);
                }
                minn=Math.min(minn,maxx);//最少秒时可以装进试管
            }
        }
        if(minn==t)
            System.out.printf("-1");//如果没有改变，输出-1
        else
            System.out.printf("%d",minn);//输出结果
    }

}
