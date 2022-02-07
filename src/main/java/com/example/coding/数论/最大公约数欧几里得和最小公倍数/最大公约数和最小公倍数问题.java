package com.example.coding.数论.最大公约数欧几里得和最小公倍数;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/17 12:19
 * @Version 1.0
 * @description:
 */
public class 最大公约数和最小公倍数问题 {
    //原数 X Y 的乘积 X*Y =最大公约数*最小公倍数
    static int m,n,ans;
    static int gcd(int a,int b){
        if(a%b==0) return b;
        else return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        if(m==n)ans--;
        n*=m;
        for(int i=1;i<=Math.sqrt(n);i++)
        {
            if(n%i==0&&gcd(i,n/i)==m) ans+=2;
        }
        System.out.println(ans);
    }
}
