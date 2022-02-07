package com.example.coding.acwing蓝桥杯;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @Author 神様だよ
 * @Date 2021/12/10 16:11
 * @Version 1.0
 * @description:
 */
public class 递归实现组合型枚举 {
    static int n,m;
    static List<List<Integer>> ans=new ArrayList<>();
    static boolean vis[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        vis=new boolean[n+1];
        dfs(m,new ArrayList<Integer>());
        PrintWriter cout=new PrintWriter(System.out);
        for (List<Integer> integers : ans) {
            for (Integer integer : integers) {
                cout.printf("%d ",integer);
            }
            cout.println();
        }

        cout.flush();
    }

    private static void dfs( int m, ArrayList<Integer> integers) {
        if(integers.size()==m){
            ans.add(new ArrayList<>(integers));
            return;
        }
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                if(!integers.isEmpty()&&i<integers.get(integers.size()-1)){
                    continue;
                }
                vis[i]=true;
                integers.add(i);
                dfs(m,integers);
                vis[i]=false;
                integers.remove(integers.size()-1);
            }
        }

    }
}
