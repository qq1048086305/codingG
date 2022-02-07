package com.example.coding.leecode.二分;

/**
 * @Author 神様だよ
 * @Date 2022/1/6 18:00
 * @Version 1.0
 * @description:
 */
public class leecode410分割数组的最大值 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length ;
        int sum = 0 ;
        int max = 0 ;
        for (int num : nums) {
            sum += num ;
            max = Math.max(max, num) ;
        }
        if (m == 1) return sum ;
        //找出答案边界
        int lo = max , hi = sum ;
        while (lo < hi) {
            int mid = lo + hi >> 1 ;
            if (check (nums, mid, m)) {
                hi = mid ;
            } else {
                lo = mid + 1;
            }
        }
        return lo ;
    }

    boolean check (int [] nums, int target, int m){
        int n = nums.length ;
        int cnt = 1 ;
        int sum = 0 ;
        for (int i = 0; i < n ; ++i) {
            if (sum + nums[i] > target) {
                sum = nums[i] ;
                cnt++;
            } else {
                sum += nums[i];
            }
            if (cnt > m) return false ;
        }
        return true;
    }
}
