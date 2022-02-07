package com.example.coding.数论.素数质数;

/**
 * @Author 神様だよ
 * @Date 2021/11/17 12:16
 * @Version 1.0
 * @description:
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class 线性筛 {
    static boolean numlist[]=new boolean[100000001];
    static int prime[]=new int[6000010], cnt;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split("\\s+");
        int n=Integer.parseInt(s[0]);
        int x=Integer.parseInt(s[1]);
        PrintWriter out=new PrintWriter(System.out);
        prime(n);
        for(int i=0;i<x;i++){
            int q=Integer.parseInt(sc.readLine());
            out.println(prime[q]);
        }
        out.flush();
    }
    static void prime(int n){
        for(int i=2; i<=n; i++){
            if(numlist[i]==false)
                prime[++cnt] = i ;
            //枚举当前有的质数
            for(int j=1; j<=cnt&&i*prime[j]<=n; j++){

                numlist[i*prime[j]] = true ;
                //遇到最小质因数就break防止重复统计
                if(i%prime[j]==0)
                    break;
            }
        }
        return;
    }

}
