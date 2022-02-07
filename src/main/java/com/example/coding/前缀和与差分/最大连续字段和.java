package com.example.coding.前缀和与差分;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 12:23
 * @Version 1.0
 * @description:
 */
public class 最大连续字段和 {
    static int n,a[]=new int[200020],b[]=new int[200020],i,ans=-2147483647;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(i=1;i<=n;i++){
            a[i]=sc.nextInt();
            if(i<2) b[i]=a[i];
            else b[i]=Math.max(a[i],b[i-1]+a[i]);
            ans=Math.max(ans,b[i]);
        }
        System.out.println(ans);
    }

}
