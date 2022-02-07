package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 11:24
 * @Version 1.0
 * @description:
 */
public class LeeCodef492构造矩形 {
    public int[] constructRectangle(int area) {
        // 根据题意找到最接近的两个数a,b a < b, 使得a*b=area, 所以a最小从sqrt(n)开始枚举
        for (int a = (int)Math.sqrt(area); a > 0; a--) {
            if (area % a == 0) return new int[]{area / a, a};
        }

        return new int[0];
    }
}
