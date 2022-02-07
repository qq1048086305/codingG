package com.example.coding.滑动窗口;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/9 12:24
 * @Version 1.0
 * @description:
 */
//窗口模型都是要把左指针带来的影响减去
public class TheNumberofWindows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < q; i++) {
            long x = sc.nextLong();
            long res = 0;
            int right = 0;
            long sum = 0;
            for (int left = 0; left < n; left++) {
                while (right < n && sum + a[right] <= x) {
                    sum += a[right];
                    ++right;
                }
                res += right - left;
                if (right == left) ++right;
                else sum -= a[left];
            }
            System.out.println(res);
        }
        // end solve
    }
}
