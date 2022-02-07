package com.example.coding.数论.高精度;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 17:11
 * @Version 1.0
 * @description:
 */
public class 小凯的数字 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sc.readLine().trim());
        String ss[];
        PrintWriter cout=new PrintWriter(System.out);
        while (n-->0){
            ss=sc.readLine().split(" ");
            int a,b;
            String s="";
            a=Integer.parseInt(ss[0]);
            b=Integer.parseInt(ss[1]);
            for(int i=a;i<=b;i++){
                s+=i+"";
            }
            BigInteger bigInteger=new BigInteger(s);
            cout.println(bigInteger.mod(bigInteger.valueOf(9)));
        }
        cout.close();
    }
}
