package com.example.coding.leecode.二分;

/**
 * @Author 神様だよ
 * @Date 2022/1/1 20:31
 * @Version 1.0
 * @description:
 */
public class leecode367判断是否是完全平方数 {
    boolean isPerfectSquare(int num) {

        int l = 1, r = num;
        while (l < r) {
            int mid = (int)(l + 1l + r )>> 1;
            if (mid <= num / mid) l = mid;
            else r = mid - 1;
        }
        return r * r == num;
    }
}
