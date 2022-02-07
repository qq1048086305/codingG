package com.example.coding.leecode.树状数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 11:27
 * @Version 1.0
 * @description:
 */
public class LeeCodes493翻转数组 {
    static int N = 50000 * 2 + 10;
    static int[] tr = new int[N];
    static int idx;
    //去重操作
    static int unique(List<Long> alls)
    {
        int j = 0;
        for(int i = 0;i < alls.size();i ++)
        {
            if(i == 0 || alls.get(i) - alls.get(i - 1) != 0)
            {
                alls.set(j ++, alls.get(i));
            }

        }
        return j;
    }
    //通过二分法计算出x位置离散化后的位置，找到第一个大于等于x的位置
    static int find(long x, List<Long> alls)
    {
        int l = 0, r = alls.size() - 1;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(alls.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return l + 1;//映射到1,2,..n
    }
    static int lowbit(int x)
    {
        return x & -x;
    }
    static void add(int x, int c)
    {
        for(int i = x;i <= idx;i += lowbit(i)) tr[i] += c;
    }
    static int sum(int x)
    {
        int res = 0;
        for(int i = x;i >= 1;i -= lowbit(i)) res += tr[i];
        return res;
    }
    public int reversePairs(int[] nums) {
        Arrays.fill(tr, 0);
        idx = 0;

        int n = nums.length;
        //存储所有用到的元素
        List<Long> alls = new ArrayList<Long>();
        for(int i = 0;i < n;i ++)
        {
            alls.add((long) nums[i]);
            alls.add((long)nums[i] * 2);
        }
        //排序
        Collections.sort(alls);
        //去重操作
        idx = unique(alls);
        //截取并返回动态数组中的一部分。
        alls = alls.subList(0, idx);
        int res = 0;
        for(int i = n - 1;i >= 0;i --)
        {
            int y = find(nums[i], alls);
            //找逆序对
            res += sum(y - 1);
            //nums[i] * 2的值出现的次数  + 1
            add(find((long)nums[i] * 2, alls), 1);
        }

        return res;
    }
}
