package com.example.coding.leecode.贪心;

import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2022/1/9 11:19
 * @Version 1.0
 * @description:
 */
public class leetCode435无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0 ;
        //右端点从小到大排序
        Arrays.sort(intervals, (a, b) ->{
            return a[1] - b[1] ;
        });
        //每次都优先选最左边
        int e = intervals[0][1] ;
        int n = intervals.length ;
        int cnt = 0 ;
        for (int i = 1 ; i < n ; ++i) {
            if (e > intervals[i][0]) {
                cnt++;
            } else {
                e = intervals[i][1] ;
            }
        }
        return cnt ;
    }
}
