package com.example.coding.数论.最大公约数欧几里得和最小公倍数;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/18 10:05
 * @Version 1.0
 * @description:
 */
public class 种田最大公约数 {
    public static void main(String[] args) {
        long x,y,ans=0;
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        while(x>0&&y>0){                          //如果x,y中有一个为0，就结束了
            //swap(x,y);                        //交换x和y，为什么？马上就知道了
            long temp=x;
            x=y;
            y=temp;
            ans+=4*y*(x/y);              //种完剩下的所有最大的正方形。很像GCD是不是？
            x%=y;                             //然后x就只剩下x%y了，因为x%y<y，所以之前需要交换
        }
        System.out.println(ans);
    }
}
