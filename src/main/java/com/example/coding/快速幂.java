package com.example.coding;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 10:51
 * @Version 1.0
 * @description:
 */
public class 快速幂 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(pow(n, m));
    }

    private static long pow(int n, int m) {
        long res = 1;
        long base = n;
        long mod = 1000000007;
        while (m != 0) {
            if ((m & 1) == 1) {
                res = res * base % mod;
            }
            base = base * base % mod;
            m = m >> 1;
        }
        return res % mod;
    }
}

