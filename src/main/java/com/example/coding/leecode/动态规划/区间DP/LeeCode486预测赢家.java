package com.example.coding.leecode.动态规划.区间DP;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 10:10
 * @Version 1.0
 * @description:
 */
public class LeeCode486预测赢家 {
    //状态表示：f[i][j]代表在区间[i,j]中当前玩家得分减去对手得分，能获得的最大值
   // 状态转移：取a[i]或取a[j]。由于状态定义是当前玩家得分减去对手得，所以a[i]-f[i+1][j]就是a[i]+自己得分减去对手得分
    public boolean PredictTheWinner(int[] nums) {
        int n=nums.length;
        int f[][]=new int[n+10][n+10];
        for(int len=1;len<=n;len++)
            for(int i=0;i+len-1<n;i++){
                int j=i+len-1;
                if(len==1) f[i][j]=nums[i];
                else
                    f[i][j]=Math.max(nums[i]-f[i+1][j],nums[j]-f[i][j-1]);
            }
        return f[0][n-1]>=0;
    }
}
