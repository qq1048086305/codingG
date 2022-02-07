package com.example.coding.背包DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/6 15:43
 * @Version 1.0
 * @description:
 */
public class 背包 {
    static int N=100005;
    static int n,m;
    static int v[]=new int[N];
    static int w[]=new int[N];
    static long f[]=new long[(int)(1e8+2)];
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split("\\s+");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        for(int i=1;i<=n;i++){
            s=sc.readLine().split("\\s+");
            w[i]=Integer.parseInt(s[0]);
            v[i]=Integer.parseInt(s[1]);
        }
        for(int i=1;i<=n;i++){
            for(int k=m;k>=v[i];k--){
                f[k]=Math.max(f[k],f[k-v[i]]+w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
