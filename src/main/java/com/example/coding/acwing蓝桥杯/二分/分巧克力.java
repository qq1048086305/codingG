package com.example.coding.acwing蓝桥杯.二分;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 16:02
 * @Version 1.0
 * @description:
 */
public class 分巧克力 {
    //优雅的二分 https://mp.weixin.qq.com/s/3fjDhS3lb5CBrzx6p0XIxw
    static int  N = 100010;
    static int w[]=new int[N], h[]=new int[N];//存储长、宽
    static int n, k;

    static boolean check(int a)
    {
        int num = 0;//记录分成长度为 a 的巧克力数量
        for (int i = 0; i < n; i++)
        {
            num += (w[i] / a) * (h[i] / a);//每一大块可以分成的边长为 a 的巧克力数量
            if (num >= k) return true;//大于要求数量，返回真
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        for (int i = 0; i < n; i++){
            h[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }
        solve();
    }

    private static void solve() {
        int l = 1, r = (int)1e5;//小巧克力数量边长一定在 1 -- 100000 之间
        while (l < r)//二分小巧克力边长范围，找到符合要求的最大值
        {
            int mid = l + (r - l + 1 >> 1);//因为l = mid ，所以 mid 取 l + r + 1 >> 1,为了防止加和越界，改写成 l + (r - l + 1 >> 1)
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        System.out.println(r);
    }
}
