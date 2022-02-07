package com.example.coding.AOJ刷题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/4 23:14
 * @Version 1.0
 * @description:
 */
public class AOJ1045解法二 {
    static Scanner sc = new Scanner(System.in);
    //
    public static void main(String[] args) {
        while (true) {
            int N = sc.nextInt();
            if (N == 0) break;
            int[] v = new int[N];
            int sum = 0;
            for (int i = 0; i < N; ++i) {
                v[i] = sc.nextInt();
                sum += v[i];
            }
            int ans = sum;
            for (int i = 1; i < (1 << N); ++i) {
                int a = 0;
                for (int j = 0; j < N; ++j) {
                    if ((i & (1 << j)) != 0) {
                        a += v[j];
                    }
                }
                ans = Math.min(ans, Math.abs(a - (sum - a)));
            }
            System.out.println(ans);
        }
    }
}
