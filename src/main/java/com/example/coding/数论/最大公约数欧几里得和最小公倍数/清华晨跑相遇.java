package com.example.coding.数论.最大公约数欧几里得和最小公倍数;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/17 17:00
 * @Version 1.0
 * @description:
 */
public class 清华晨跑相遇 {


    static long  x, y, z;
    static long gcd(long x,long y) {
        return  y==0 ? x : gcd(y, x % y);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        z=sc.nextInt();
        x = x / gcd(x, y) * y;
        z = z / gcd(z, x) * x;
        System.out.printf("%d\n", z);
    }

}
