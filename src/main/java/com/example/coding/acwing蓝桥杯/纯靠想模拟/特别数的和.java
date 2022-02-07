package com.example.coding.acwing蓝桥杯.纯靠想模拟;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/17 17:09
 * @Version 1.0
 * @description:
 */
public class 特别数的和 {
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int res = 0;

        for (int i = 1; i <= n; i ++ )
        {
            int x = i;
            while(x>0)
            {
                int t = x % 10;  // 取出x的个位数
                x /= 10;         // 取它的上一位
                if (t == 0 || t == 2 || t == 1 || t == 9)
                {
                    res += i;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
