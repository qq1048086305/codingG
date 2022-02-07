package com.example.coding.leecode.树状数组;

import java.util.ArrayList;

/**
 * @Author 神様だよ
 * @Date 2022/1/11 11:59
 * @Version 1.0
 * @description:
 */
public class LeetCode456一三二模式 {
    /**
     * 首先将原数组元素离散化到区间 [1, n] 中，并将除了首元素外每个数字的值加入到树状数组的对应位置上，
     * 即对所有 i>0i>0 执行 update(a[i], 1)。
     * 定义 left_min 表示数组前 i 个元素的最小值，初始令 left_min=nums[0]。
     * 从位置 1 开始枚举 高峰 的位置，然后需要用树状数组寻找 i 之后是否有元素在 [left_min+1, nums[i]-1] 中。
     * 枚举时，首先将 nums[i] 从树状数组中删除，然后判断 num[i] 是否小于 left_min，
     * 若为真，则更新 left_min，继续枚举下一个位置；若为假，判断query(nums[i] - 1) - query(left_max) > 0，
     * 查看找到了 132 模式。
     */

    /**
     * class Solution {
     * public:
     *     vector<int> f;
     *     int m;
     *
     *     void update(int x, int y) {
     *         for (; x <= m; x += x & -x)
     *             f[x] += y;
     *     }
     *
     *     int query(int x) {
     *         int tot = 0;
     *         for (; x; x -= x & -x)
     *             tot += f[x];
     *         return tot;
     *     }
     *
     *     bool find132pattern(vector<int>& nums) {
     *         int n = nums.size();
     *         if (n < 3)
     *             return false;
     *         vector<int> b(nums);
     *
     *         sort(b.begin(), b.end());
     *         m = unique(b.begin(), b.end()) - b.begin();
     *         b.resize(m);
     *
     *         f = vector<int>(m + 1, 0);
     *
     *
     *         for (auto &x : nums)
     *             x = lower_bound(b.begin(), b.end(), x) - b.begin() + 1;
     *
     *         for (int i = 1; i < n; i++)
     *             update(nums[i], 1);
     *
     *         int left_min = nums[0];
     *
     *         for (int i = 1; i < n; i++) {
     *             update(nums[i], -1);
     *             if (nums[i] < left_min)
     *                 left_min = nums[i];
     *             else {
     *                 if (query(nums[i] - 1) - query(left_min) > 0)
     *                     return true;
     *             }
     *         }
     *
     *         return false;
     *     }
     * };

     */
}
