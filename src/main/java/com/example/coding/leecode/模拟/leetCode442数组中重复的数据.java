package com.example.coding.leecode.模拟;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/10 16:49
 * @Version 1.0
 * @description:
 */
public class leetCode442数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int t = Math.abs(nums[i])-1;
            nums[t] *= -1;
            if(nums[t] > 0){
                list.add(Math.abs(nums[i]));
            }
        }
        return list;
    }
}
