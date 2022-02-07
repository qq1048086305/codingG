package com.example.coding;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/5 22:15
 * @Version 1.0
 * @description:
 */
public class 矩阵链乘法 {
    static int N=100;
    static int INF=1<<25;
    static int n,p[]=new int[N+1],m[][]=new int[N+1][N+1];
    static int matrixchainmultiplication(){
        for(int i=1;i<=n;i++) m[i][i]=0;
        for(int l=2;l<=n;l++){
            for(int i=1;i<=n-l+1;i++){
                int j=i+l-1;
                m[i][j]=INF;
                for(int k=i;k<=j-1;k++){
                    m[i][j]=Math.min(m[i][j],m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j]);
                }
            }
        }
        return m[1][n];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
            p[i+1]=sc.nextInt();
        }
        System.out.println(matrixchainmultiplication());
    }

}
