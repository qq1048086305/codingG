package com.example.coding.acwing蓝桥杯;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/10 15:45
 * @Version 1.0
 * @description:
 */
public class 简单的斐波那契 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter cout=new PrintWriter(System.out);
        int n=sc.nextInt();
        long a=1;
        long b=1;
        long ans=a+b;
        for(int i=0;i<n;i++){
            if(i==0){
                cout.print("0 ");
            }else if(i==1){
                cout.print("1 ");
            }else if(i==2){
                cout.print("1 ");
            }else{
                ans=a+b;
                a=b;
                b=ans;
                cout.printf("%d ",ans);
            }
        }
        cout.flush();
    }
}
