package com.example.coding.leecode.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/12/28 12:36
 * @Version 1.0
 * @description:
 */
public class leecode350两个数组的交集 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1); // 使用元素较少的数组建查找表
        // 使用 hashmap 注册 nums1 中所有数字
        HashMap<Integer, Integer> freq = new HashMap<>(); // <num, times>
        for (int num : nums1) freq.put(num, freq.getOrDefault(num, 0) + 1);
        // 遍历 nums2 中数字，找到交集存入 list
        List<Integer> ans = new ArrayList<>();

        for (int num : nums2) {
            if (freq.containsKey(num) && freq.get(num) != 0) {
                ans.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        int[] ret = new int[ans.size()];
        int idx = 0;
        for (int num : ans) ret[idx++] = num;
        return ret;
    }
}
