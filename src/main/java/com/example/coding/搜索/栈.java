package com.example.coding.搜索;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 19:07
 * @Version 1.0
 * @description:
 */
public class 栈 {
    static int dp[][]=new int[20][20];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(dfs(n,0));;
    }
    //n队列里的数 i栈里的数字 根据栈分类讨论即可
    private static int dfs(int n, int i) {
        if(n==0){
            return 1;
        }
        if(dp[n][i]>0){
            return dp[n][i];
        }
        if(i>0){
            //栈元素大于0 我们可以选择弹出来
            dp[n][i]+=dfs(n,i-1);
        }
        //否则就是栈得到一个 序列减少一个
        return dp[n][i]+=dfs(n-1,i+1);
    }
}
