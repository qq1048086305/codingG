package com.example.coding.AOJ刷题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/4 10:43
 * @Version 1.0
 * @description:
 */
public class AOJ1041 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            int n=sc.nextInt();
            if(n==0){
                break;
            }
            int sum=0;
            for(int i=0;i<n/4;i++){
                sum+=sc.nextInt();
            }
            System.out.println(sum);
        }

    }
}
