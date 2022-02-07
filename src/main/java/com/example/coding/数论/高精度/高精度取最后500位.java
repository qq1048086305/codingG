package com.example.coding.数论.高精度;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 8:57
 * @Version 1.0
 * @description:
 */
public class 高精度取最后500位 {
    public static void main(String[] args) {
        BigInteger x=BigInteger.valueOf(2l);
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int n=sc.nextInt();
        x=x.pow(n).subtract(BigInteger.ONE);
        System.out.println(x.toString().length());
        int len=x.toString().length();

        int m=len/50;
        String s=x.toString();
        if(len<500){
            for(int i=0;i<10-m-1;i++){
                for(int j=0;j<50;j++){
                    out.print("0");
                }
                out.println();
            }
        }
        int k=len%50;
        if(len%50!=0){
            int xx=50-k;
            int count=0;
            for(int i=0;i<xx;i++){
                out.print("0");
            }
            out.println(s.substring(0,k));
        }
        s=s.substring(k);
        for(int i=0;i<m;i++){
            out.println(s.substring(0,50));
            s=s.substring(50);
        }
        out.flush();
    }
}
