package com.example.coding.acwing蓝桥杯.纯靠想模拟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/12/17 17:00
 * @Version 1.0
 * @description:
 */
public class 递增三元组 {
    static int N = 100010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static int[] c = new int[N];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        String[] s1 = reader.readLine().split(" ");
        String[] s2 = reader.readLine().split(" ");
        String[] s3 = reader.readLine().split(" ");
        for(int i = 1;i <= n;i++) a[i] = Integer.parseInt(s1[i - 1]);
        for(int i = 1;i <= n;i++) b[i] = Integer.parseInt(s2[i - 1]);
        for(int i = 1;i <= n;i++) c[i] = Integer.parseInt(s3[i - 1]);
        Arrays.sort(a,1,n + 1);
        Arrays.sort(b,1,n + 1);
        Arrays.sort(c,1,n + 1);
        long res = 0;
        //枚举b[]数组
        for(int i = 1;i <= n;i++)
        {
            //找到a[]数组中最小的大于等于bi的元素位置
            int la = 0,ra = n + 1;
            while(la < ra)
            {
                int mid = (la + ra) >> 1;
                if(a[mid] >= b[i]) ra = mid;
                else la = mid + 1;
            }
            //找到c[]数组中最大的小于等于bi的元素位置
            int lb = 0,rb = n + 1;
            while(lb < rb)
            {
                int mid = (lb + rb + 1) >> 1;
                if(c[mid] <= b[i]) lb = mid;
                else rb = mid - 1;
            }
            if(la == 0 || lb == n + 1) continue;
            res += ((long)(la - 1) *(n - lb));
        }
        System.out.println(res);
    }
}
