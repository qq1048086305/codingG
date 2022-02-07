package com.example.coding.leecode.解析几何;

import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 8:56
 * @Version 1.0
 * @description:
 */
public class 矩形面积 {
    //https://leetcode-cn.com/problems/rectangle-area/
    //无论两个方体怎么相交，相交的区域的左下角一定是(x1,y1)，右上角一定是(x2,y2)
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[] x = new int[4];
        int[] y = new int[4];
        x[0] = A; y[0] = B;
        x[1] = C; y[1] = D;
        x[2] = E; y[2] = F;
        x[3] = G; y[3] = H;
        int sum = (x[1] - x[0]) * (y[1] - y[0]) + (x[3] - x[2]) * (y[3] - y[2]);
        if(x[0] >= x[3] || x[1] <= x[2] || y[0] >= y[3] || y[1] <= y[2])
            return sum;
        else
        {
            Arrays.sort(x,0,4);
            Arrays.sort(y,0,4);
            int t = (x[1] - x[2]) * (y[1] - y[2]);//重叠的面积
            return sum - t;
        }
    }
}
