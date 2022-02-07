package com.example.coding.leecode.前缀和与后缀和;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 9:24
 * @Version 1.0
 * @description:
 */
public class 除自身以外数组的乘积 {
    //不能使用除法
    //维护前缀和和后缀和 i-1*i+1即可
    //https://www.acwing.com/solution/content/20074/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0;i < n;i ++)
        {
            if(i == 0) left[i] = nums[i];
            else left[i] = left[i - 1] * nums[i];
        }
        for(int i = n - 1;i >= 0;i --)
        {
            if(i == n - 1) right[i] = nums[i];
            else right[i] = right[i + 1] * nums[i];
        }

        int[] res = new int[n];
        for(int i = 0;i < n;i ++)
        {
            int t = 1;
            if(i - 1 >= 0) t *= left[i - 1];
            if(i + 1 <= n - 1) t *= right[i + 1];
            res[i] = t;
        }
        return res;
    }
}
