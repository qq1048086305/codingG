package com.example.coding.acwing蓝桥杯.数学;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 17:11
 * @Version 1.0
 * @description:
 */
public class 蚂蚁感冒 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int len=100;
        int a[]=new int[n+1];
        int x=0,y=0;
        int temp=0;
        for(int i=1;i<=n;i++){
            int tmp=sc.nextInt();
            a[i]=(tmp);
        }
        int ans=1;
        temp=a[1];
        int left=0,right=0;
        for(int i=2;i<=n;i++){
            if(a[i]<0&&Math.abs(a[i])>Math.abs(temp)){
                right++;
            }
            if(a[i]>0&&Math.abs(a[i])<Math.abs(temp)){
                left++;
            }
        }
        //特殊情况
        if ((temp < 0 && left == 0) || temp > 0 && right == 0){
            System.out.println(1);
        }else{
            System.out.println(left+right+ans);
        }
    }
}
