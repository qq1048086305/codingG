package com.example.coding.leecode.前缀和双指针二分等结合;

import java.util.HashSet;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 8:39
 * @Version 1.0
 * @description:
 */
//set
public class leecode217存在重复元素 {
    //https://leetcode-cn.com/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0;i < nums.length;i ++)
        {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
