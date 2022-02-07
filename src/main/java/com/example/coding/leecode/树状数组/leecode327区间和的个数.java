package com.example.coding.leecode.树状数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author 神様だよ
 * @Date 2021/12/24 9:03
 * @Version 1.0
 * @description:
 */
public class leecode327区间和的个数 {
    int[] tr;

    public int lowbit(int x) {
        return x & (-x);
    }

    public void add(int x, int c) {
        for (int i = x; i < tr.length; i += lowbit(i)) {
            tr[i] += c;
        }
    }

    public int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tr[i];
        }
        return res;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        Set<Long> set = new HashSet<>();
        set.add(0l);
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            set.add(sum[i]);
            set.add(sum[i] - lower);
            set.add(sum[i] - upper - 1);
        }
        long[] ids = new long[set.size()];
        int id = 0;
        for (Long i : set) {
            ids[id++] = i;
        }
        tr = new int[id + 1];
        int res = 0;
        Arrays.sort(ids);
        add(Arrays.binarySearch(ids, 0) + 1, 1);
        for (int i = 1; i < sum.length; i++) {
            res += query(Arrays.binarySearch(ids, sum[i] - lower) + 1) - query(Arrays.binarySearch(ids, sum[i] - upper - 1) + 1);
            add(Arrays.binarySearch(ids, sum[i]) + 1, 1);
        }
        return res;
    }

    public static void main(String[] args) {
        leecode327区间和的个数 s = new leecode327区间和的个数();
        s.countRangeSum(new int[]{-1, 1}, 0, 0);
    }
}
