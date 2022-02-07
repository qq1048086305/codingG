package com.example.coding.数论.因子个数;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/18 13:49
 * @Version 1.0
 * @description:
 */
public class 因子个数和 {
    //https://www.luogu.com.cn/blog/yltx/solution-p1403
    static int n,ans;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=n;i++)ans+=n/i;
        System.out.println(ans);
    }
}
