package com.example.coding.leecode.动态规划;

/**
 * @Author 神様だよ
 * @Date 2022/1/22 11:15
 * @Version 1.0
 * @description:
 */
public class LeeCode518零钱兑换 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] f = new int[amount + 10];
        f[0] = 1;
        for(int i = 0;i < n;i ++)
        {
            for(int j = coins[i];j <= amount;j ++)
                f[j] += f[j - coins[i]];
        }
        return f[amount];
    }
}
