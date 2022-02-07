package com.example.coding.AOJ刷题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/4 23:06
 * @Version 1.0
 * @description:
 */
public class AOJ1045 {
    static int ans=Integer.MAX_VALUE/2;
    static int n;
    static int arr[]=new int[n];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            n=sc.nextInt();
            if(n==0){
                return;
            }
            arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            ans=Integer.MAX_VALUE/2;
            dfs(0,0,0);
            System.out.println(ans);
        }
    }

    private static void dfs(int u, int sumA, int sumB) {
        if(u==n){
            ans=Math.min(ans,Math.abs(sumA-sumB));
            return;
        }
        dfs(u+1,sumA+arr[u],sumB);
        dfs(u+1,sumA,sumB+arr[u]);
    }
}
