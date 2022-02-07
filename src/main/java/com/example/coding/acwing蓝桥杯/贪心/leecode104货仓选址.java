package com.example.coding.acwing蓝桥杯.贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/21 19:56
 * @Version 1.0
 * @description:
 */
public class leecode104货仓选址 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] A = new int[n];
        for(int i = 0;i < n;i++) A[i] = scan.nextInt();
        Arrays.sort(A);
        int mid = (n - 1)/2;
        int sum = 0;
        for(int i = 0;i < n;i++) sum += Math.abs((A[mid] - A[i]));
        System.out.println(sum);
    }
}
