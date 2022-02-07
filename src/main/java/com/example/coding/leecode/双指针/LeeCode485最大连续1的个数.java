package com.example.coding.leecode.双指针;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 10:07
 * @Version 1.0
 * @description:
 */
public class LeeCode485最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int res = 0;
        //双指针统计
        for(int i = 0;i < n;i ++)
        {
            if(nums[i] == 1)
            {
                int j = i;
                while(j < n && nums[j] == 1) j ++;
                res = Math.max(res, j - i);
                i = j - 1;
            }
        }
        return res;
    }
}
