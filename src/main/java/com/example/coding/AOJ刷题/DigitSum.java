package com.example.coding.AOJ刷题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/30 15:18
 * @Version 1.0
 * @description:
 */
public class DigitSum {
    //a数组是ans数组代表每个数字能从几个数字转换过来
    static int a[]=new int[2000005];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        Arrays.fill(a,1);//默认持有自己
        for(int i=1;i<=N;i++){
            int sum=0;
            int cur=i;
            while (cur!=0){
                sum+=cur%10;
                cur=cur/10;
            }
            a[i+sum]+=a[i];
        }
        System.out.println(a[N]);
    }
}
