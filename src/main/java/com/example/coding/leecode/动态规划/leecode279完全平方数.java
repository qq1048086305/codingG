package com.example.coding.leecode.动态规划;

import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 14:16
 * @Version 1.0
 * @description:
 */
public class leecode279完全平方数 {
    //https://leetcode-cn.com/problems/perfect-squares/
    //https://www.acwing.com/solution/content/20190/
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for(int i = 1;i <= n;i ++)
            for(int j = 0;j * j <= i;j ++)
                f[i] = Math.min(f[i], f[i - j * j] + 1);

        return f[n];
    }
}
