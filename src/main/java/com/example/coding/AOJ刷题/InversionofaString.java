package com.example.coding.AOJ刷题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/30 14:18
 * @Version 1.0
 * @description:
 */
public class InversionofaString {
    //字符串局部反转
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        String S = sc.next();
        String result = S.substring(0, a - 1);

        for(int i = b - 1; i >= a - 1; i--){
            result += S.substring(i, i + 1);
        }

        result += S.substring(b, n);

        System.out.println(result);
    }
}
