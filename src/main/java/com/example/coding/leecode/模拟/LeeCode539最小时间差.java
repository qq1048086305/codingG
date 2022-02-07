package com.example.coding.leecode.模拟;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/23 9:36
 * @Version 1.0
 * @description:
 */
public class LeeCode539最小时间差 {
    //都转化成分钟然后排序
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] min = new int[n];
        int k = 0;
        for(String time: timePoints){
            min[k++] = Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3,5));
        }
        Arrays.sort(min);
        int res = 1440;
        for(int i = 1; i < n; i++){
            res = Math.min(res, min[i] - min[i-1]);
        }
        return Math.min(res, 1440 + min[0] - min[n-1]);
    }
}
