package com.example.coding.acwing蓝桥杯.纯靠想模拟;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/18 15:50
 * @Version 1.0
 * @description:
 */
public class 归并排序 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a,1,n+1);
        for(int i=1;i<=n;i++){
            System.out.print(a[i]+" ");
        }
    }
}
