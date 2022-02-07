package com.example.coding.acwing蓝桥杯.纯靠想模拟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/12/17 16:53
 * @Version 1.0
 * @description:
 */
public class 连号区间 {
    static int N = 10010;
    static int[] f = new int[N];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        String[] s1 = reader.readLine().split(" ");
        for(int i = 1;i <= n;i++) f[i] = Integer.parseInt(s1[i - 1]);
        int res = 0;
        for(int i = 1;i <= n;i++)
        {
            int minv = Integer.MAX_VALUE;
            int maxv = Integer.MIN_VALUE;
            for(int j = i;j <= n;j++)
            {
                minv = Math.min(minv, f[j]);
                maxv = Math.max(maxv, f[j]);
                if(maxv - minv == j - i) res ++;
            }
        }
        System.out.println(res);
    }
}
