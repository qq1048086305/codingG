package com.example.coding.leecode.动态规划.背包;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 17:21
 * @Version 1.0
 * @description:
 */
public class leecode377组合总数 {
    public int combinationSum4(int[] nums, int m) {
        int n=nums.length;
        int f[][]=new int[m+1][m+1];
        f[0][0]=1;
        int res=0;
        for(int i=1;i<=m;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<n;k++){
                    if(j-nums[k]>=0){
                        f[i][j]=f[i][j]+f[i-1][j-nums[k]];
                    }
                }
            }
            res+=f[i][m];
        }
        return res;

    }
}
