package com.example.coding.leecode.二分;

/**
 * @Author 神様だよ
 * @Date 2021/12/13 8:57
 * @Version 1.0
 * @description:
 */
public class leecode下一个排列 {
    //https://leetcode-cn.com/problems/next-permutation/submissions/
    static void swap(int[] nums,int l,int r)
    {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
    static void reverse(int[] nums,int l,int r)
    {
        while(l < r) swap(nums,l ++,r --);
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        //1、从右往左找到第一个下降的点k
        int k = n - 2;
        while(k >= 0 && nums[k] >= nums[k + 1]) k --;
        if(k == -1)
        {
            reverse(nums,0,n - 1);
        }
        else
        {
            //2、从[k + 1,n - 1]区间中找到 > nums[k] 的最小值
            int l = k + 1,r = n - 1;
            while(l < r)
            {
                int mid = l + r + 1 >> 1;
                if(nums[mid] > nums[k]) l = mid;
                else r = mid - 1;
            }
            //3、交换k和l的位置
            swap(nums,k,l);
            //4、将[k + 1,n - 1]区间的元素逆序
            reverse(nums,k + 1,n - 1);
        }
    }

}
