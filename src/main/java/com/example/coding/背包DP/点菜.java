package com.example.coding.背包DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 20:48
 * @Version 1.0
 * @description:
 */
public class 点菜 {
    static int f[][]=new int[1005][1005];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        int m;
        n=sc.nextInt();
        m=sc.nextInt();
        int v[]=new int[n+1];
        for(int i=0;i<1005;i++){
            //i个物品只有零元方案就是1 不买
            f[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            v[i]=sc.nextInt();
            for(int vv=1;vv<=m;vv++){

                f[i][vv]+=f[i-1][vv];
                if(vv-v[i]>=0){
                  f[i][vv]+=f[i-1][vv-v[i]];
                }
            }
        }
        System.out.println(f[n][m]);
    }
}
