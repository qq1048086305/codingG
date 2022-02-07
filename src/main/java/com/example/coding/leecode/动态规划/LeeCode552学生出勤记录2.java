package com.example.coding.leecode.动态规划;

/**
 * @Author 神様だよ
 * @Date 2022/1/23 10:08
 * @Version 1.0
 * @description:
 */
public class LeeCode552学生出勤记录2 {
    public int checkRecord(int n) {
        int mod = (int)1e9+7;
        //前i个字符,j个'A', 末尾k个连续L的方案数
        int[][][] f = new int[n+1][2][3];
        f[0][0][0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= 1; j++){
                for(int k = 0; k <= 2; k++){
                    // P
                    f[i+1][j][0] = (f[i+1][j][0] + f[i][j][k]) % mod;
                    // A
                    if(j < 1) f[i+1][j+1][0] = (f[i+1][j+1][0] + f[i][j][k]) % mod;
                    // L
                    if(k < 2) f[i+1][j][k+1] = (f[i+1][j][k+1] + f[i][j][k]) % mod;
                }
            }
        }
        int res = 0;
        for(int j = 0; j <= 1; j++){
            for(int k = 0; k <= 2; k++){
                res = (res + f[n][j][k]) % mod;
            }
        }
        return res;
    }
}
