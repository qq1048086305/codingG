package com.example.coding.打表;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 22:02
 * @Version 1.0
 * @description:
 */
public class GoldenFeather {
    static long n,T;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter cout=new PrintWriter(System.out);
        T=sc.nextLong();
        for(int i=1;i<=T;i++){
            n=sc.nextLong();
            if(n==4||n==10)cout.println(n+1);
            else cout.println(n-1);
        }
        cout.close();
    }
}
