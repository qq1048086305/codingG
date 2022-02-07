package com.example.coding.leecode.动态规划;

import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2022/1/7 21:35
 * @Version 1.0
 * @description:
 */
public class leeCode416分割等和子集 {
    public boolean canPartition(int[] nums) {
        // 从数组中选数，每个数只能用一次，选出来的数的总和恰好为数组总和的一半
        // 数组中每个数都对应一个物品，物品的体积表示数值，背包容量是数组总和的一半
        // dp(i,j) 表示只从前i个元素中选，总和是否恰好为j（注意里面存的是布尔类型）
        // dp(i,j) = dp(i-1, j) | dp(i-1, j-nums[j]) 不选第i个元素总和恰好为j
        // 或者，一定选第i个元素，那么要想总和为j就应该把第i个物品的体积减掉，也就
        // 总和恰好为j-nums[i]
        // 初始化：dp(0, 0~j)从第0个元素里面选总和是否恰好为j，判断第0个元素是否等于j
        // 如果等于就是true，否则就是false
        // dp(0~i,0)从前i个物品里面选，总和恰好为0，这里应该都是true, 因为一个都不选就满足条件
        // 返回的结果：dp(i-1, sum/2) sum 表示的是整个数组的和、

        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i ++) sum += nums[i];
        // 注意，如果数组总和是奇数，那么肯定是不满足条件的
        if (sum % 2 == 1) return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[n][target + 1]; // target+1是因为初始化的时候把总和为0的情况考虑进去了
        // 初始化 dp[0~i][0]
        for (int i = 0; i < n; i ++) dp[i][0] = true;
        // 初始化dp[0][0~j], 需要注意每个元素最多只能选一次，所以只需要判断第0个元素与体积的关系，只有恰好等于才为true
        // 其他的初始值都是false, 先全部初始化为false, 然后再找出恰好等于的情况
        Arrays.fill(dp[0], false);
        if (nums[0] <= target) dp[0][nums[0]] = true;

        for (int i = 1; i < n; i ++) {
            for (int j = 1; j <= target; j ++) {
                // 两种情况只要有一种情况成立就可以
                dp[i][j] |= dp[i - 1][j];

                if (j >= nums[i])
                    dp[i][j] |= dp[i - 1][j - nums[i]];
            }
        }

        return dp[n - 1][target];
    }
}
