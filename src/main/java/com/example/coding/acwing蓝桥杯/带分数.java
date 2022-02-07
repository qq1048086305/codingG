package com.example.coding.acwing蓝桥杯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/10 16:38
 * @Version 1.0
 * @description:
 */
public class 带分数 {
    static int target;
    static int cnt=0;
    static List<Integer> ans=new ArrayList<>();
    static boolean vis[]=new boolean[11];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        target=sc.nextInt();
        dfs(0);
        System.out.println(cnt);

    }

    private static void dfs(int u) {//当前选了几个数
        if(u==9){
            //枚举三部分
            for(int i=0;i<7;i++){//留两个数给后面
                for(int j=i+1;j<8;j++){//留一个数给后面
                    int a=sum(0,i);
                    int b=sum(i+1,j);
                    int c=sum(j+1,8);
                    if(a * c + b == c * target){
                        cnt++;
                    }
                }

            }
          return;
        }
        for(int i=1;i<=9;i++){
               if(!vis[i]){
                   vis[i]=true;
                   ans.add(i);
                   dfs(u+1);
                   vis[i]=false;
                   ans.remove(ans.size()-1);
               }
        }
    }
    private static int sum(int i,int j){//返回 i->j的和
        int sum=0;
        for(int k=i;k<=j;k++ ){
            sum=sum*10+ans.get(k);
        }
        return sum;
    }
}
