package com.example.coding.leecode.模拟;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 神様だよ
 * @Date 2022/1/22 12:16
 * @Version 1.0
 * @description:
 */
public class LeeCode523连续子数组和 {
    //前缀和差是0代表是k的倍数
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            for (int i = 1; i < n; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) {
                return true;
            }
        }
        return false;
    }

}
