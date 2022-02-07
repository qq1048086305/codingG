package com.example.coding.leecode.数论;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 9:39
 * @Version 1.0
 * @description:
 */
public class leecode260只出现一次的数 {
    static int get(int[] nums, int k, int t)
    {
        int res = 0;
        for(int c : nums)
        {
            if((c >> k & 1) == t)
                res ^= c;
        }
        return res;
    }
    public int[] singleNumber(int[] nums) {
        int ab = 0;
        for(int c : nums) ab ^= c;

        int k = 0;
        while((ab >> k & 1) == 0) k ++;
        return new int[]{get(nums, k, 0), get(nums, k, 1)};
    }
}
