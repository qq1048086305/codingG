package com.example.coding.leecode.动态规划;

/**
 * @Author 神様だよ
 * @Date 2022/1/22 11:04
 * @Version 1.0
 * @description:
 */
public class LeeCode516最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        s = " " + s;
        int[][] f = new int[n + 10][n + 10];
        for(int len = 1;len <= n;len ++)
        {
            for(int i = 1;i + len - 1 <= n;i ++)
            {
                int j = i + len - 1;
                if(len == 1) f[i][j] = 1;
                else
                {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                    if(s.charAt(i) == s.charAt(j)) f[i][j] = Math.max(f[i][j], f[i + 1][j - 1] + 2);
                }
            }
        }
        return f[1][n];
    }
}
