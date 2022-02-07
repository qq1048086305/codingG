package com.example.coding.acwing蓝桥杯.DP.最长上升子序列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 19:12
 * @Version 1.0
 * @description:
 */
public class 子序列 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=sc.nextInt();
        }
        int f[]=new int[n+1];
        Arrays.fill(f,1);
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(a[i]>a[j]){
                    f[i]=Math.max(f[j]+1,f[i]);
                }
            }
            ans=Math.max(f[i],ans);
        }
        System.out.println(ans);
    }
}
