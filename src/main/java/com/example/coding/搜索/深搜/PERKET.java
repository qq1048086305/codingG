package com.example.coding.搜索.深搜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/14 17:03
 * @Version 1.0
 * @description:
 */
public class PERKET {

    static int M=15;
    static int a[]=new int[M],b[]=new int[M],n,ans=0x7f;
    //ans初始化为最大值
    static void dfs(int i,int x,int y){
       //i是表示目前的配料编号，x为酸度，y为甜度
        if(i>n){
            //注意，必须大于n才表示全部搜完
            if(x==1&&y==0)return;
            //判断清水的情况
            ans=Math.min(Math.abs(x-y),ans);
            //更新ans
            return;
        }
        //分两种情况搜索：1添加 2不添加
        dfs(i+1,x*a[i],y+b[i]);
        dfs(i+1,x,y);
        //这题无需回溯，不明白为何有些题解居然还用全局变量，非得回溯-_-||
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        for(int i=1;i<=n;i++){
            String[] split = sc.readLine().split(" ");
            a[i]=Integer.parseInt(split[0]);
            b[i]=Integer.parseInt(split[1]);
            //读入，用cin太慢了
        }
        dfs(1,1,0);
        System.out.printf("%d\n",ans);
    }

}
