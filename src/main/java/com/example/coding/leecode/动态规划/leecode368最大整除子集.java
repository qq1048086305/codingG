package com.example.coding.leecode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/1 20:37
 * @Version 1.0
 * @description:
 */
public class leecode368最大整除子集 {
    /**
     * 最长上升子序列变种 因为需要满足相邻元素整除 才满足题目要求
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f,1);
        int k = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
            if(f[k] < f[i]) k = i;
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[k]);
        //相当于搜索一遍dp表
        while(f[k] > 1){
            for(int i = 0; i < k; i++){
                if(nums[k] % nums[i] == 0 && f[k] == f[i] + 1){
                    res.add(nums[i]);
                    k = i;
                    break;
                }
            }
        }
        return res;
    }
}
