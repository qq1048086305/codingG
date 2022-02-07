package com.example.coding.AOJ刷题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/29 18:59
 * @Version 1.0
 * @description:
 */
public class TrunkRoad {
    static int A[][]=new int[26][26];
    static int n,m;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        //录入数据
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int ans=Integer.MAX_VALUE/2;
        //枚举所有交叉点 找到当前状态下的距离和 枚举所有可能筛选出最小值
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.min(ans,getDist(i,j));
            }
        }
        System.out.println(ans);
    }

    private static int getDist(int x, int y) {
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=Math.min(Math.abs(x-i), Math.abs(y-j))*A[i][j];
            }
        }
        return sum;
    }
}
