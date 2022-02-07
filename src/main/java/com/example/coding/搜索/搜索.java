package com.example.coding.搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author 神様だよ
 * @Date 2021/11/5 13:22
 * @Version 1.0
 * @description:
 */
public class 搜索 {
    static int arr[]=new int[25];
    static int n;
    static int dp[][]=new int[25][2005];
    static boolean st[]=new boolean[25];
    static int max=Integer.MAX_VALUE;
    static int min;
    static Set<Integer> set=new HashSet<>();

    /**
     * 发现怎么剪枝都过不了，那咱们换个思路 数组规模小就20个提前把能加出来的结果都算出来不就好了吗？
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
         n=Integer.parseInt(sc.readLine().trim()) ;
        String s[]=sc.readLine().split(" ");
        max=0;

        for (int i = 0; i < s.length; i++) {
            arr[i]=Integer.parseInt(s[i]);
            max+=arr[i];
            Math.min(arr[i],max);
        }
        Arrays.fill(st,false);
        dfs2(0,0);
        int q=Integer.parseInt(sc.readLine().trim()) ;
        s=sc.readLine().split(" ");
        for(int i=0;i<q;i++){
            int goal=Integer.parseInt(s[i]);
            if(set.contains(goal)){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

    private static boolean dfs(int sum, int goal) {
        if(goal==max){
            return true;
        }
        if(goal==min){
            return true;
        }
        if(goal>max){
            return false;
        }
        if(goal<min){
            return false;
        }
        if(sum>goal){
            return false;
        }
        if(sum==goal){
            return true;
        }
        for(int i=0;i<n;i++){
           if(!st[i]){
               st[i]=true;
               if(dfs(sum+arr[i],goal)){
                   return true;
               }
               st[i]=false;
           }
        }
        return false;
    }
    //提前把能搜到的所有内容都算起来存到哈希表里
    private static void dfs2(int sum,int cnt) {
        if(sum>max||cnt==n){
            set.add(sum);
            return;
        }
        dfs2(sum+arr[cnt],cnt+1);
        dfs2(sum,cnt+1);
    }
}
