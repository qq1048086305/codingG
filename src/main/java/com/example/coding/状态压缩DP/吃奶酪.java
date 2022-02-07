package com.example.coding.状态压缩DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/15 8:17
 * @Version 1.0
 * @description:
 */
public class 吃奶酪 {
    /**
     * https://www.luogu.com.cn/blog/novax13/solution-p1433
     */
    static double a[][]=new double[20][20];//预处理，从第i块到第j块的距离，使用两点之间距离公式
    static double x[]=new double[20],y[]=new double[20];//每块奶酪的横、纵坐标
    static double F[][]=new double[18][34000];//状压DP数组 在第i个点上，走过的二进制状态的十进制表达为j时，最短的距离
    static int N;
    static double distance(int v,int w)//计算第v个和第w个奶酪之间的距离
    {
        return Math.sqrt((x[v]-x[w])*(x[v]-x[w])+(y[v]-y[w])*(y[v]-y[w]));//两点间距离公式
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i,j,k;
        double ans;
        //这样可以给浮点数赋值无穷大
        for(int jj=0;jj<18;jj++){
         Arrays.fill(F[jj],127);
        }
        ans=F[0][0];
        N=sc.nextInt();
        for(i=1;i<=N;i++)
        {
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
        }
        x[0]=0;y[0]=0;
        for(i=0;i<=N;i++)
        {
            for(j=i+1;j<=N;j++)
            {   //每个点到另一个点的距离都给算一下
                a[i][j]=distance(i,j);//初始化距离数组
                a[j][i]=a[i][j];
            }
        }
        for(i=1;i<=N;i++)//初始化
        {   //每一个单个1的奶酪距离原点距离初始化一下
            F[i][(1<<(i-1))]=a[0][i];//在i点上且只有经过i点时距离是原点到i点的距离
        }
        for(k=1;k<(1<<N);k++)//枚举所有二进制的状态 00000 11111  个数是N 从小到大
        {
            for(i=1;i<=N;i++)
            {
                if((k&(1<<(i-1)))==0)
                    continue;//i的位置没被走过
                for(j=1;j<=N;j++)//如果i走过了
                {
                    if(i==j)
                        continue;//同一个点不需要再计算
                    if((k&(1<<(j-1)))==0)
                        continue;//j的位置没走过
                    //更新第i个奶酪下的k状态
                    F[i][k]=Math.min(F[i][k],F[j][k-(1<<(i-1))]+a[i][j]);
                }
            }
        }
        for(i=1;i<=N;i++)
        {
            ans=Math.min(ans,F[i][(1<<N)-1]);
        }
        System.out.printf("%.2f\n",ans);
    }
}
