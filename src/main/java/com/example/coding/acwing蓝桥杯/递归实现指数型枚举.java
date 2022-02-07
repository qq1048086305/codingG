package com.example.coding.acwing蓝桥杯;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/10 15:27
 * @Version 1.0
 * @description:
 */
public class 递归实现指数型枚举 {
    static HashSet<List<Integer>> set=new HashSet<>();
    static Integer n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter cout=new PrintWriter(System.out);
        n=sc.nextInt();
        dfs(1,new ArrayList<Integer>());
        for (List<Integer> integers : set) {
            for (Integer integer : integers) {
                cout.printf("%d ",integer);
            }
            cout.println();
        }
        cout.flush();
    }

    private static void dfs(int u, ArrayList<Integer> integers) {
        if(u>n){
            set.add(new ArrayList<>(integers));
            return;
        }
        integers.add(u);
        dfs(u+1,integers);
        integers.remove(integers.size()-1);
        dfs(u+1,integers);
    }


}
