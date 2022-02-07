package com.example.coding.图树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/11/5 21:38
 * @Version 1.0
 * @description:
 */
public class tree {
    static int n;
    static int N=100005;
    static List<Integer> list[]=new List[1500];
    static int []fa=new int[N];
    static boolean[]st=new boolean[N];
    static int [] dep=new int[N];
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim()) ;
        for(int i=0;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        int tmp=n;
        while(tmp-->0){
            String[] s = sc.readLine().split(" ");

            int id=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            if(m==0){
                continue;
            }
            for (int j = 2; j < s.length; j++) {
                list[id].add(Integer.parseInt(s[j]));
            }
        }

        Arrays.fill(fa,-1);
        for(int i=0;i<n;i++){
            if(!st[i]){
                dfs(i,0);
            }
        }
        for(int i=0;i<n;i++){
            System.out.print("node "+i+": parent = "+fa[i]+", depth = "+dep[i]);
            if(fa[i]<0) System.out.print(", root, [");
            else if(list[i].size()==0) System.out.print(", leaf, [");
            else System.out.print(", internal node, [");
            for(int j=0;j<(int)list[i].size();j++){
                if(j>0) System.out.print(", ");
                System.out.print(list[i].get(j));
            }
            System.out.println("]");
        }

    }

    public static void dfs(int u, int de) {
        //当前节点当前深度
        dep[u]=de;
        for(int i=0;i<list[u].size();i++){
            int j=list[u].get(i);
            if(!st[j]){
                st[j]=true;
                dfs(j,de+1);
                fa[j]=u;
            }
        }
    }
}
