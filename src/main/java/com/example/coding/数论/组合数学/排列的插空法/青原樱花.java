package com.example.coding.数论.组合数学.排列的插空法;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/29 16:12
 * @Version 1.0
 * @description:
 */
public class 青原樱花 {
    //https://225425.blog.luogu.org/solution-p5520
    static int I, love, yin, lin;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        I=sc.nextInt();
        love=sc.nextInt();
        yin=sc.nextInt();
        lin=sc.nextInt();
        love = love - yin + 1;
        long ans = 1;
        for (int i = love - yin + 1; i <= love; ++i) {
            ans = 1l * ans * i % lin;
        }
        System.out.printf("%d\n", ans);
    }
}
