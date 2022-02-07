package com.example.coding.leecode.动态规划;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 11:38
 * @Version 1.0
 * @description:
 */
public class LeeCode494目标和 {
    //前i个数选 总和为S的所有方案 可能选正可能选负数
    public int findTargetSumWays(int[] nums, int S) {
        if(S < -1000 || S > 1000) return 0;
        int n = nums.length, Offset = 1000;//偏移1000位
        int[][] f = new int[n + 1][2010];
        f[0][Offset] = 1;
        for(int i = 1;i <= n;i ++)
            for(int j = -1000;j <= 1000;j ++)
            {
                if(j - nums[i - 1] >= -1000) f[i][j + Offset] = f[i - 1][j - nums[i - 1] + Offset];
                if(j + nums[i - 1] <= 1000) f[i][j + Offset] += f[i - 1][j + nums[i - 1] + Offset];
            }

        return f[n][S + Offset];
    }

}
