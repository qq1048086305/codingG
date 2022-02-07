package com.example.coding.leecode.贪心;

import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2022/1/11 11:31
 * @Version 1.0
 * @description:
 */
public class LeetCode452用最少数量的箭引爆气球 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0 ;
        int n = points.length ;
        //按区间右端点从小到大排序
        Arrays.sort(points, (a, b) -> {
            if (a[1] <= b[1]) {
                return -1 ;
            }
            return 1 ;
        });

        int ret = 1 ;
        int end = points[0][1] ;
        //选点
        for (int i = 1 ; i < n ; ++i) {
            if (end < points[i][0]) {
                end = points[i][1] ;
                ret++;
            }
        }
        return ret;
    }
}

