package com.example.coding.leecode.动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 神様だよ
 * @Date 2022/1/4 21:16
 * @Version 1.0
 * @description:
 */
public class leecode403青蛙跳 {
    int[] stones;
    Map<Integer, Integer> map;//记忆化搜索
    int[][] f;

    public boolean canCross(int[] stones) {
        //f(i,j) 表示从第i个石头开始跳跃j的距离是否合法
        this.stones = stones;
        this.map = new HashMap<>();
        int  n = stones.length;
        for (int i = 0; i < n; i++){
            map.put(stones[i], i);
        }
        f = new int[n + 1][n + 1];
        for (int i = 0; i <  n; i++){
            Arrays.fill(f[i], -1);
        }
        f[0][1] = 1;
        for (int i = 0; i < n; i++){
            if (dp(n - 1, i) > 0)
                return true;
        }
        return false;
    }
    int dp (int i, int j){
        if (f[i][j] != - 1) return f[i][j];
        f[i][j] = 0;
        for (int k = Math.max(1, j - 1); k <= j + 1; k++){
            if (map.get(stones[i] - k) != null){
                int p = map.get(stones[i] - k);
                if (dp(p, k) > 0){
                    f[i][j] = 1;
                    break;
                }
            }
        }
        return f[i][j];
    }
}
