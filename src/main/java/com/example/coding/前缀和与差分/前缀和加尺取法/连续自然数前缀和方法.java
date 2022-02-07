package com.example.coding.前缀和与差分.前缀和加尺取法;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 16:38
 * @Version 1.0
 * @description:
 */
public class 连续自然数前缀和方法 {
    //前缀和
    static int m;
    static int sum[]=new int[1000005];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        PrintWriter out=new PrintWriter(System.out);
        for(int i=1;i<=1000000;i++)//第一条
        {
            sum[i]=sum[i-1]+i;//前缀和
        }

        for(int i=1;i<=m/2+1;i++)//枚举左端点
        {
            for(int j=i;j>=1;j--)//枚举右端点
            {
                if(sum[i]-sum[j-1]>m)break;//优化
                if(sum[i]-sum[j-1]==m&&i!=j)
                {
                    out.printf("%d %d\n",j,i);
                }
            }
        }
        out.flush();//习惯
    }
}
