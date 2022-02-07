package com.example.coding.leecode.数论;

/**
 * @Author 神様だよ
 * @Date 2022/1/6 18:23
 * @Version 1.0
 * @description:
 */
public class leeCode413等差数列划分 {
    //差分数组 + 等差数列 + 双指针
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int res = 0;
        int[] diff = new int[n];
        for (int i = 1; i < n; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j + 1 < n && diff[j + 1] == diff[i]) {
                j++;
            }
            int k = j - i + 1;
            res += k * (k - 1) / 2;
            i = j;
        }
        return res;
    }
}
