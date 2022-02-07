package com.example.coding.AOJ刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/29 17:22
 * @Version 1.0
 * @description:
 */
public class Pencils {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split(" ");
        int N,A,B,C,D;
        N=Integer.parseInt(s[0]);
        A=Integer.parseInt(s[1]);
        B=Integer.parseInt(s[2]);
        C=Integer.parseInt(s[3]);
        D=Integer.parseInt(s[4]);
        if(N<A&&N<C){
            System.out.println(Math.min(B,D));
            return;
        }
        if(N<A||N<C){
            if(N<A){
                int b=N/C;
                if(b*C<N){
                    b+=1;
                }
                System.out.println(Math.min(B,b*D));
                return;
            }else{
                int a=N/A;
                if(a*A<N){
                    a+=1;
                }
                System.out.println(Math.min(D,a*B));
                return;
            }
        }
        int a=N/A;
        int b=N/C;
        if(a*A<N){
            a+=1;
        }
        if(b*C<N){
            b+=1;
        }
        int ans=Math.min(a*B,b*D);
        System.out.println(ans);
    }
}
