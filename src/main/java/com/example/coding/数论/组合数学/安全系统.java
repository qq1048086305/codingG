package com.example.coding.数论.组合数学;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/16 16:43
 * @Version 1.0
 * @description:
 */
public class 安全系统 {
    /**
     * https://www.luogu.com.cn/blog/x4Cx58x54/solution-p2638
     */
    /**
     * 组合数就用杨辉三角嘛没什么好说的
     */
    static int N=105;
    static int n,a,b,c[][]=new int[N][N];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        a=sc.nextInt();
        b=sc.nextInt();
        for(int i=0;i<=100;i++)//初始化 这个应该好理解
            c[0][i]=c[i][i]=1;
        for(int i=1;i<=100;i++)
            for(int j=2;j<=100;j++)
                c[i][j]=c[i][j-1]+c[i-1][j-1];  //题目范围是50，稍微弄大点

        BigInteger temp1=BigInteger.ZERO,temp2=BigInteger.ZERO;
        //把0和1分开看，把a个0放入n个区域中，等价于在n个区域中选择0~a个区域放0,1同理。
        //
        //又因为每个1和每个0都不同，所以拿出的i个0或1又有c[i][a]或c[i][b]种方案
        //
        //故，我们可以得到最后的公式：
        for(int i=0;i<=a;i++)
            temp1=temp1.add(BigInteger.valueOf(c[i][n]*c[i][a]));
        for(int i=0;i<=b;i++)
            temp2=temp2.add(BigInteger.valueOf(c[i][n]*c[i][b]));
        System.out.printf("%d",temp1.multiply(temp2));
    }
}
