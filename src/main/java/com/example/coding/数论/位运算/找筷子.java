package com.example.coding.数论.位运算;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/16 12:54
 * @Version 1.0
 * @description:
 */
public class 找筷子 {
    //找出数组中唯一的奇数
    public static void main(String[] args) throws IOException {
        Scanner scc=new Scanner(System.in);
        int n=scc.nextInt();
        //村到数组里太占用内存了
        int ans=0;
        for(int i=1;i<=n;i++){
            int x=scc.nextInt();
            ans^=x;
        }
        System.out.println(ans);
    }
}
