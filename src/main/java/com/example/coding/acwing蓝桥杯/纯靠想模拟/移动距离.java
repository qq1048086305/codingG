package com.example.coding.acwing蓝桥杯.纯靠想模拟;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/18 15:56
 * @Version 1.0
 * @description:
 */
public class 移动距离 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int w,n,m;
        w=sc.nextInt();
        n=sc.nextInt();
        m=sc.nextInt();
        int cowA,colA,cowB,colB;
        int max=Math.max(n,m);
        int min=Math.min(n,m);
        if(n<=w&&m<=w){
            System.out.println(n-m);
            return;
        }
        cowB=max%w==0?max/w:max/w+1;
        cowA=min%w==0?min/w:min/w+1;
        colB=getCol(max,w,cowB);
        colA=getCol(min,w,cowA);
        System.out.println(Math.abs(colB-colA)+Math.abs(cowB-cowA));

    }

    private static int getCol(int cur, int w,int level) {
        if(level%2==0){//偶数算列 倒过来
            if(cur%w==0){
                return 1;
            }else{
                return w-cur%w+1;
            }
        }else{
            if(cur%w==0){
                return w;
            }else{
                return cur%w;
            }
        }
    }
}
