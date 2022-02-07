package com.example.coding.刷题.二分;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 15:34
 * @Version 1.0
 * @description:
 */
public class 字符串替换 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(sc.readLine());
        String s=sc.readLine();
        System.out.println(s.replaceAll("joi", "JOI"));

    }
}
