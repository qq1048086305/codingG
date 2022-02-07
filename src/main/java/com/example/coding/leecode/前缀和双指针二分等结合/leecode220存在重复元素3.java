package com.example.coding.leecode.前缀和双指针二分等结合;

import java.util.TreeSet;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 8:41
 * @Version 1.0
 * @description:
 */

//滑动窗口+2分
public class leecode220存在重复元素3 {
    //https://leetcode-cn.com/problems/contains-duplicate-iii/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if(n < 2) return false;
        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0;i < n;i ++)
        {
            Long e = (long)nums[i];
            Long l = set.floor(e);//窗口中小于等于e的最大值
            Long r = set.ceiling(e);//窗口中大于等于e的最小值
            if(l != null && e - l <= t) return true;
            if(r != null && r - e <= t) return true;
            set.add(e);
            if(set.size() > k) set.remove((long)nums[i - k]);
        }
        return false;
    }
    /**
     * 注意：此处用TreeSet来维护滑动窗口，因为floor(E x)可以找到小于等于e的最大值，ceiling(E x)可以找到大于等于e的最小值，并且TreeSet本身是排序好的
     */
}
