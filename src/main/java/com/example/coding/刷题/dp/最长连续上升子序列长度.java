package com.example.coding.刷题.dp;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 15:38
 * @Version 1.0
 * @description:
 */
public class 最长连续上升子序列长度 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n+1];
        int dp[]=new int[n+1];
        for(int i=1;i<=n;i++){
           a[i]=sc.nextInt();
        }
        dp[1]=1;
        int ans=dp[1];
        for(int i=2;i<=n;i++){
           dp[i]=1;
           if(a[i-1]<=a[i]){
               dp[i]=dp[i-1]+1;
               ans=Math.max(dp[i],ans);
           }
        }
        System.out.println(ans);
    }
}
