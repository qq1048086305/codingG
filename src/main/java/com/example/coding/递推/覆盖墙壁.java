package com.example.coding.递推;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 21:28
 * @Version 1.0
 * @description:
 */
public class 覆盖墙壁 {
    //题解
    //https://www.luogu.com.cn/blog/222223/solution-p1990
    static int F[]=new int[1000010];				//方案数
    static int preF[]=new int[1000010];			//前缀和
    static int n;
    //考虑墙壁怎么放第n列涂满的时候可以由前n-1列竖着放 n-1 和 n-2 列横着放 加上放L型的方案数得到
    //L型可以旋转要除以二 n-3之前全都可以由L型凑出来 故是一个2倍(旋转)的F[N-3->1]累加和
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        F[0]=1;//代表长为n的墙产生的方案数
        preF[0]=1;//方案数的前缀数组
        for(int i=1;i<=n;i++){
            //<0时候就是0 %10000
            F[i]=(i-3<0?0:preF[i-3])+(i-1<0?0:preF[i-1]);
            F[i]%=10000;
            preF[i]=F[i]+preF[i-1];
            //结果保留4位  %10000
            preF[i]%=10000;
        }
        System.out.println(F[n]);
    }
}
