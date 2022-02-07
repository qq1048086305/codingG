package com.example.coding.leecode.双指针;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 9:13
 * @Version 1.0
 * @description:
 */
//https://leetcode-cn.com/problems/summary-ranges/
public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<String>();
        for(int i = 0;i < n;i ++)
        {
            int j = i + 1;
            while(j < n && nums[j] == nums[j - 1] + 1) j ++;
            int a = nums[i], b = nums[j - 1];
            if(i == j - 1) ans.add("" + a);
            else ans.add(a + "->" + b);
            i = j - 1;
        }
        return ans;
    }
}
