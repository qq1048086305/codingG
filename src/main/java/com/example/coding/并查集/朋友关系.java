package com.example.coding.并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/5 22:39
 * @Version 1.0
 * @description:
 */
public class 朋友关系 {
    static int N=100005;
    static int f[]=new int[N];
    public static int find(int x){
        if(f[x]==x){
            return x;
        }
        return f[x]=find(f[x]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        //分隔空格一定要用这个不然会被卡可能（恶心）
        String[] s = sc.readLine().split("\\s+");
        int m=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1]);
        //并查集初始化
        for(int i=0;i<N;i++){
            f[i]=i;
        }
        for(int i=0;i<k;i++){
            s = sc.readLine().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            f[find(b)]=find(a);
        }
        int q=Integer.parseInt(sc.readLine());
        for(int i=0;i<q;i++){
            s = sc.readLine().split("\\s+");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            if(find(a)==find(b)){
                out.println("yes");
                out.flush();
            }else{
                out.println("no");
                out.flush();
            }
        }
    }
}
