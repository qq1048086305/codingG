package com.example.coding.刷题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 10:45
 * @Version 1.0
 * @description:
 */
public class 浮点型期望值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double EPS = 1e-13;//10的负13次方
        double[] res = new double[100001];
        res[1] = 1;
        for(int n=2;n<=100000;n++){
            //p代表总概率 之后会变成在n次条件下得到盒饭的概率
            double p = 1, win = 0.5;
            int k = 1;
            //加上得不到盒饭的期望值
            //失败k次的概率
            //递推数学期望 在前一种期望情况基础上加上当前情况的概率（别忘了加当前的长度）
            while(EPS<p && k<n){
                double not = p*(1-win);//失败产生的概率
                //算出n-k-1成功的总数期望值
                double xx=k+res[Math.max(0,n-k-1)];
                res[n] += not*(k+res[Math.max(0,n-k-1)]);
                //算出连续赢下去的概率
                p*=win; win/=2;k++;//古典概型
            }
            //加上得到盒饭的期望值
            res[n]+=n*p;
        }
        for(;;){
            int n = sc.nextInt();
            if(n==0)break;
            System.out.printf("%.8f\n", res[n]);
        }
    }
}
