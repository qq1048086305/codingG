package com.example.coding.leecode.动态规划.最长上升子序列变体;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 17:18
 * @Version 1.0
 * @description:
 */
public class leecode376摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, res = 0;
        int[][] f = new int[n][2];
        for (int i = 0; i < n; i++) {
            f[i][0] = f[i][1] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) f[i][1] = Math.max(f[i][1], f[j][0] + 1);
                if (nums[i] < nums[j]) f[i][0] = Math.max(f[i][0], f[j][1] + 1);
            }
            res = Math.max(res, Math.max(f[i][0], f[i][1]));
        }
        return res;
    }
}
