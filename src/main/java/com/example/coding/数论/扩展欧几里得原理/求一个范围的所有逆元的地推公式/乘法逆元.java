package com.example.coding.数论.扩展欧几里得原理.求一个范围的所有逆元的地推公式;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 16:30
 * @Version 1.0
 * @description:
 */
public class 乘法逆元 {
    /**
     * https://www.luogu.com.cn/blog/user49618/solution-p3811
     */
    static long inv[]=new long[3000010];
    //递推公式 加一下是防止出现负数 相当于-p/i+p
    public static void main(String[] args) throws IOException {
        inv[1]=1;
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split(" ");
        int n,p;
        PrintWriter cout=new PrintWriter(System.out);
        n=Integer.parseInt(s[0]);
        p=Integer.parseInt(s[1]);
        for(int i=2;i<=n;i++){
            inv[i]=(p-p/i)*inv[p%i]%p;
        }
        for(int i=1;i<=n;i++){
            cout.println(inv[i]);
        }
        cout.close();
    }
}
