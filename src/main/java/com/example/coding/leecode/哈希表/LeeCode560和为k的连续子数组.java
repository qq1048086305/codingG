package com.example.coding.leecode.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 神様だよ
 * @Date 2022/1/23 10:54
 * @Version 1.0
 * @description:
 */
public class LeeCode560和为k的连续子数组 {
    /**
     * 和为 k 的连续的子数组，如果是和接近k，可以用TreeMap。
     * 直接用前缀和是O(N^2)。
     * 当前前缀和s[i]为s，如果有前缀和s[j]为s - k，即存在区间[j + 1, i]为k。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;
        // 计算前缀和数组
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + nums[i];

        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);

        for (int i = 1; i <= n; i++) {

            ans += hash.getOrDefault(preSum[i] - k, 0);
            hash.put(preSum[i], hash.getOrDefault(preSum[i], 0) + 1);
        }
        return ans;
    }
}
