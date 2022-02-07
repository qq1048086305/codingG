package com.example.coding.刷题.数论;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 20:35
 * @Version 1.0
 * @description:
 */
public class DigitSum {
    static int N;
    static boolean dp[]=new boolean[10000005];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        Arrays.fill(dp,false);
        dp[N] = true;
        for (int i = N-1; i >= 0; i--)
        {
            int x = i;
            int step = i;
            while (0 < x)
            {   //每次加自己的十进制位如果最后能凑出来N就标记成true
                step += x % 10;
                x /= 10;
            }
            if (dp[step] == true)
            {
                dp[i] = true;
            }
        }

        int res = 0;

        for (int i = 0; i <= N; i++)
        {
            if (dp[i] == true)
                res++;
        }

        System.out.println(res);
    }
}
