package com.example.coding.搜索;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 20:42
 * @Version 1.0
 * @description:
 */
public class 蜜蜂 {
    static BigInteger f[]=new BigInteger[1005];

    public static void main(String[] args) {
        Arrays.fill(f,BigInteger.ZERO);
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        f[1]=BigInteger.ONE;
        f[2]=BigInteger.ONE;
        for(int i=3;i<=m-n+1;i++){
            f[i]=f[i-1].add(f[i-2]);
        }
        System.out.println(f[m-n+1]);
    }
}
