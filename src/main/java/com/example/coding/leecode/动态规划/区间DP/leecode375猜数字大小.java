package com.example.coding.leecode.动态规划.区间DP;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 17:12
 * @Version 1.0
 * @description:
 */
public class leecode375猜数字大小 {
    public int getMoneyAmount(int n) {
        //若要赢得比赛，需要计算最坏情况下需要的花费。每次猜，若错了，则会将答案定位在一个连续区间中，用区间dp来做，dp[i,j] 表示在i,j区间范围内最小的现金。
        // i,j区间中可以任选k，选 一个最小的， dp[i,j] = min(dp[i,k]),  dp[i, k] = max(dp[i, k -1] , dp[k + 1, j]) + k
        int[][] f = new int[n + 2][n + 2];
        // 下面几行是区间dp的标准写法
        for (int len = 2; len <= n; len++) { // 枚举每个区间长度
            for (int i = 1; i + len - 1 <= n; i++) { // 枚举起点
                int j = i + len - 1; // 区间终点
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {// 遍历区间中所有可能取值
                    f[i][j] = Math.min(f[i][j], Math.max(f[i][k - 1], f[k + 1][j]) + k);
                }
            }
        }

        return f[1][n];

    }
}
