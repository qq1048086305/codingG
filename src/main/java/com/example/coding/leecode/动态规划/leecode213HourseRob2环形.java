package com.example.coding.leecode.动态规划;

/**
 * @Author 神様だよ
 * @Date 2021/12/3 16:31
 * @Version 1.0
 * @description:
 */
public class leecode213HourseRob2环形 {
    /**
     * 对于线性 f[i][0] = max(f[i-1][0],f[i-1][1]) ; f[i][1]=f[i-1][0]+w[i] ,对于环形，我们可以用枚举的方法，我们假设第一个点不选，那么f[0][0] = 0,f[0][1]=-INF(不合法) ，
     * 最后的最大值就是max(f[n-1][0],f[n-1][1]) ;
     * 假设第一个点选，那么f[0][0]=-INF,f[0][1]=w[0],最后一个点就不能选，最大值只能是f[n-1][0]
     * ，最后的答案在两者中取最大即可
     */
    //https://leetcode.com/problems/house-robber-ii/submissions/
}
