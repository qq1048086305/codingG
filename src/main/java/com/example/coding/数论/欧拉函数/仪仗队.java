package com.example.coding.数论.欧拉函数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 21:59
 * @Version 1.0
 * @description:
 */
//https://www.luogu.com.cn/blog/skounputer/solution-p2158
public class 仪仗队 {
    static int n , ans ;
    static int f[]=new int[50000];

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        PrintWriter cout=new PrintWriter(System.out);
        if( n == 1 ){
            cout.printf("0\n");
            cout.flush();
            return ;
        }
        ans = ( n -1 ) * ( n - 1 ) ;
        n-- ;
        for(int i = n ; i >= 2 ; i--){
            f[i] = ( n /i ) * ( n / i ) ;
            for(int j = 2 * i ; j <= n ;j += i ) f[i] -= f[j] ;
            ans -= f[i] ;
        }
        cout.printf("%d",ans + 2 );
        cout.flush();
    }

}
