package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/10 16:43
 * @Version 1.0
 * @description:
 */
public class leetCode441排列硬币 {
    public int arrangeCoins(int n) {
        int k = 0, ans = 0;
        while (k < n) {
            k++;
            n -= k;
            ans++;
        }
        return ans;
    }
}
