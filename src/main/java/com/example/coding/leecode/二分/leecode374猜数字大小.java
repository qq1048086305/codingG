package com.example.coding.leecode.二分;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 16:59
 * @Version 1.0
 * @description:
 */
public class leecode374猜数字大小 {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + r + 1 >>> 1;
            if (guess(mid) >= 0) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    private int guess(int mid) {
        return 0;
    }
}
