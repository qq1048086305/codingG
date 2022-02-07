package com.example.coding;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 11:40
 * @Version 1.0
 * @description:
 */
public class 欧拉函数 {
    static int euler(int num){

        int ret = num;

        for(int i = 2; i*i <= num;  i++){
            if(num%i == 0) {
                ret  = ret/i*(i-1);
                while(num%i == 0)num /= i;
            }
        }
        if(num != 1) ret = ret/num*(num-1);
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(euler(n));
    }
}
