package com.example.coding.leecode.数论.欧几里得;

/**
 * @Author 神様だよ
 * @Date 2022/1/1 20:26
 * @Version 1.0
 * @description:
 */
public class leecode365水壶问题 {
    public boolean canMeasureWater(int x, int y, int z) {
        // 这里要用壶装水，多了装不下。
        if (z > x + y) return false;
        //判断有解无解即可
        return z == 0 || z % gcd(x, y) == 0;
    }

    // 递归
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /*// 迭代
    private int gcd(int x, int y) {
        while (y > 0) {
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
    }*/
}
