package com.example.coding.leecode.动态规划;

/**
 * @Author 神様だよ
 * @Date 2021/12/23 9:44
 * @Version 1.0
 * @description:
 */
public class leecode312戳气球区间dp {
    //https://leetcode-cn.com/problems/burst-balloons/submissions/
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] boll=new int[n+2];
        int[][] f=new int[n+2][n+2];//长度默认加2 用来处理边界 因为dp定义为不包括i j位置气球
        for(int i=0;i<n+2;i++){
            if(i==0||i==n+1)boll[i]=1;
            else boll[i]=nums[i-1];
        }
        for(int len=3;len<=n+2;len++){
            for(int i=0;i+len-1<n+2;i++){
                int j=i+len-1;
                for(int k=i+1;k<j;k++){
                    f[i][j]=Math.max(f[i][j],f[i][k]+f[k][j]+boll[k]*boll[i]*boll[j]);
                }
            }
        }
        return f[0][n+1];
    }
}
