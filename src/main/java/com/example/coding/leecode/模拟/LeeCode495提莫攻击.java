package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 11:45
 * @Version 1.0
 * @description:
 */
public class LeeCode495提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int ed = -1;
        int res = 0;
        for(int i = 0;i < n;i ++)
        {   //大于结束时间区间无重叠
            if(timeSeries[i] > ed)
            {
                res += duration;
                ed = timeSeries[i] + duration - 1;

            }
            //区间有重叠
            else
            {
                res += timeSeries[i] + duration - 1 - ed;
                ed = timeSeries[i] + duration - 1;
            }
        }
        return res;
    }
}
