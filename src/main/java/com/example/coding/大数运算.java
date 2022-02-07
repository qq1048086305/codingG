package com.example.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 12:31
 * @Version 1.0
 * @description:
 */
public class 大数运算 {
    public static void main(String[] args) throws IOException {
        BigInteger a;
        BigInteger b;
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String[] s = sc.readLine().split(" ");
        a=new BigInteger(s[0]);
        b=new BigInteger(s[1]);
        System.out.println(a.add(b));
    }
}
