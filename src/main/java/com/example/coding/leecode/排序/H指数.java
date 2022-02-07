package com.example.coding.leecode.排序;

import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 9:49
 * @Version 1.0
 * @description:
 */
public class H指数 {
    //https://www.acwing.com/activity/content/problem/content/2644/
    public int hIndex(int[] c) {
        Arrays.sort(c);
        int n = c.length;
        for(int i = 0;i < n;i ++)
        {
            if(c[i] >= n - i)
            {
                return n - i;
            }
        }
        return 0;
    }
}
