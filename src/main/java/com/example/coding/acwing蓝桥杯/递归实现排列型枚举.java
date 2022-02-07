package com.example.coding.acwing蓝桥杯;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/10 15:33
 * @Version 1.0
 * @description:
 */
public class 递归实现排列型枚举 {
    static List<List<Integer>> ans=new ArrayList<>();
    static int n;
    static boolean vis[]=new boolean[10];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter cout=new PrintWriter(System.out);
        n=sc.nextInt();
        dfs(1,new ArrayList<Integer>());
        for (List<Integer> integers : ans) {
            for (Integer integer : integers) {
                cout.printf("%d ",integer);
            }
            cout.println();
        }
        cout.flush();
    }

    private static void dfs(int u, ArrayList<Integer> integers) {
        if(u>n&&integers.size()==n){
            ans.add(new ArrayList<>(integers));
            return;
        }
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                integers.add(i);
                vis[i]=true;
                dfs(u+1,integers);
                vis[i]=false;
                integers.remove((integers.size()-1));
            }
        }
    }
}
