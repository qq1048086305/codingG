package com.example.coding.递归;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 15:36
 * @Version 1.0
 * @description:
 */
public class 数楼梯 {
    static BigInteger dp[]=new BigInteger[5005];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Arrays.fill(dp, BigInteger.ZERO);
        int n=sc.nextInt();
        if(n==0){
            System.out.println(1);
            return;
        }
        System.out.println(dfs(n));
    }
    private static BigInteger dfs(int n) {
        if(n<0){
            return BigInteger.ZERO;
        }
        if(dp[n].compareTo(BigInteger.ZERO)>0){
            return dp[n];
        }
        if(n==0){
            return BigInteger.ONE;
        }
        dp[n]=dfs(n-2).add(dfs(n-1));
        return dp[n];
    }

}
