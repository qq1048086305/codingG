package com.example.coding.刷题.二分;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 15:16
 * @Version 1.0
 * @description:
 */
//看似二分实际上却不是 仅仅是个迷惑题
public class 最接近的数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int left,right;
        left=sc.nextInt();
        right=sc.nextInt();
        int ans=Integer.MAX_VALUE/2;
        if (x>=right){
            System.out.println(right);
        }else if(x<=left){
            System.out.println(left);
        }else{
            System.out.println(x);
        }
    }
    public static int check(){
      return 0;
    }
}
