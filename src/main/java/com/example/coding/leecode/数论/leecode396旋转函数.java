package com.example.coding.leecode.数论;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 20:44
 * @Version 1.0
 * @description:
 */
public class leecode396旋转函数 {
    //找规律发现 知道第一个和name所有和也就求出来了
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += i * A[i];
        }
        int res = cur;
        for (int i = n - 1; i >= 0; i--) {
            cur += sum - n * A[i];
            res = Math.max(res, cur);
        }
        return res;
    }
}
