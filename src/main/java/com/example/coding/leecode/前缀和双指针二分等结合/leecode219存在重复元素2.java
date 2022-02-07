package com.example.coding.leecode.前缀和双指针二分等结合;

import java.util.HashMap;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 8:40
 * @Version 1.0
 * @description:
 */
public class leecode219存在重复元素2 {
    //https://www.acwing.com/solution/content/19827/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i < nums.length;i ++)
        {
            int x = nums[i];
            if(map.containsKey(x) && i - map.get(x) <= k)   return true;
            map.put(x, i);
        }
        return false;
    }
}
