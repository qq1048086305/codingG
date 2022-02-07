package com.example.coding.前缀和与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 12:38
 * @Version 1.0
 * @description:
 */
public class 地毯 {
    //二维差分
    static int a[][]=new int[1005][1005];

    public static void main(String[] args) throws IOException {
        int n,m,xa,ya,xb,yb;
        BufferedReader scc=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        String[] strings = scc.readLine().split("\\s+");
        n=Integer.parseInt(strings[0]);
        m=Integer.parseInt(strings[1]);
        PrintWriter out=new PrintWriter(System.out);
        for(int i=1;i<=m;++i){
            String[] split = scc.readLine().split("\\s+");
            xa=Integer.parseInt(split[0]);
            ya=Integer.parseInt(split[1]);
            xb=Integer.parseInt(split[2]);
            yb=Integer.parseInt(split[3]);
            ++a[xa][ya];
            --a[xb+1][ya];
            --a[xa][yb+1];
            ++a[xb+1][yb+1];
        }
        for(int i=1;i<=n;++i)for(int j=1;j<=n;++j)out.printf("%d%c",a[i][j]+=a[i-1][j]+a[i][j-1]-a[i-1][j-1],j==n?'\n':' ');
        out.flush();
    }
}
