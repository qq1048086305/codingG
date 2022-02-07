package com.example.coding.leecode.动态规划.背包;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 11:36
 * @Version 1.0
 * @description:
 */
public class Leecode494目标和 {
    /**
     * 、把所有符号为正的数总和设为一个背包的容量，容量为x
     * 2、把所有符号为负的数总和设为一个背包的容量，容量为y。
     * 3、在给定的数组中，有多少种选择方法让背包装满。令sum为数组的总和，则x+y = sum。而两个背包的差为S,则x-y=S。从而求得x=(S+sum)/2。
     * 4、基于上述分析，题目转换为背包问题：给定一个数组和一个容量为x的背包，求有多少种方式让背包装满。
     */
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i < n;i ++) sum += nums[i];

        if((S + sum) % 2 == 1) return 0;//S + sum是奇数则无解
        if(S > sum) return 0;
        int x = (S + sum) / 2;

        int[] f = new int[x + 1];
        f[0] = 1;
        for(int i = 0;i < n;i ++)
            for(int j = x;j >= nums[i];j --)
                f[j] += f[j - nums[i]];
        return f[x];
    }
}
