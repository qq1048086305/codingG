package com.example.coding.leecode.双指针;

import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2022/1/23 9:32
 * @Version 1.0
 * @description:
 */
public class LeeCode532数字diff对 {
    //排序+双指针
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0, j = 0; i < n; i++){
            while(i+1 < n && nums[i] == nums[i+1]) i++;
            while(j < i && nums[i] - nums[j] > k) j++;
            if(j < i && nums[i] - nums[j] == k) res++;
        }
        return res;
    }
}
