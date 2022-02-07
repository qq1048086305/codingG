package com.example.coding.leecode.树状数组;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/12/24 8:11
 * @Version 1.0
 * @description:
 */
public class leecode315计算右侧小于当前元素个数 {
    //https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/submissions/
    int[] sum;
    int n = 20010;

    public int lowbit(int x) {
        return x & (-x);
    }

    public int get(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += sum[i];
        }
        return res;
    }

    public void add(int x, int c) {
        for (int i = x; i <= n; i += lowbit(i)) {
            sum[i] += c;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        sum = new int[n];
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i] + 10001;
            res.add(get(x - 1));
            add(x, 1);
        }
        Collections.reverse(res);
        return res;
    }
}
