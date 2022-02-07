package com.example.coding.leecode.二分;

/**
 * @Author 神様だよ
 * @Date 2022/1/23 9:38
 * @Version 1.0
 * @description:
 */
public class LeeCode540有序数组的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        //相等的情况向右找 不相等想左找 不相等情况下第一个数就是答案 可以二分成两种情况
        while(l < r){
            int mid = l + r >> 1;
            // 下标为偶数，经过异或是下标 + 1。下标是奇数，经过异或还是当前下标。
            if(nums[mid] != nums[mid ^ 1]){
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l];
    }
}
