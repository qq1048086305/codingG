package com.example.coding.二分搜索;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/7 17:51
 * @Version 1.0
 * @description:
 */
public class 二分搜索左边右边两种情况 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            if (arr[0] >= x) {
                sb.append(0);
            } else {
                int left = 0;
                int right = n;
                while (right - left > 1) {
                    int m = (left + right) / 2;
                    if (arr[m] < x) {
                        left = m;
                    } else {
                        right = m;
                    }
                }
                sb.append(right);
            }
            sb.append(" ");
            if (arr[0] > x) {
                sb.append(0);
            } else {
                int left = 0;
                int right = n;
                while (right - left > 1) {
                    int m = (left + right) / 2;
                    if (arr[m] <= x) {
                        left = m;
                    } else {
                        right = m;
                    }
                }
                sb.append(right);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
