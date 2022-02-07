package com.example.coding.刷题.水题;


import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 14:50
 * @Version 1.0
 * @description:
 */
public class 三个整数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[]=new int[4];
        int x,y,z;
        x=sc.nextInt();
        y=sc.nextInt();
        z=sc.nextInt();
        a[x]++;
        a[y]++;
        a[z]++;
        if(a[2]>a[1]){
            System.out.println(2);
        }else{
            System.out.println(1);
        }
    }
}
