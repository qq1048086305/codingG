package com.example.coding.并查集;

/**
 * @Author 神様だよ
 * @Date 2021/11/7 19:09
 * @Version 1.0
 * @description:
 */

import java.util.Scanner;

/**
 * 查询每个节点到根节点的值
 * 给一个函数可以改变节点值
 */
@SuppressWarnings("unchecked")
public class 带权并查集 {
    static int N=200001;
    static int f[]=new int[N];
    static int[] weight=new int[N];
    public static int find(int x){
        if(f[x]==x){
            return x;
        }
        int r=find(f[x]);
        weight[x]+=weight[f[x]];//weight[x]记录到根节点的距离，一定要有一个思想，
        // 根节点是一个区间的一个端点而不是一个区间，输入的区间被合并成了两个点
        return f[x]=r;//返回父节点
    }
    public static int weight(int x) {
        find(x);
        return weight[x];
    }
    public static void diff(int x,int y){
        if(find(x)==find(y)){
            System.out.println(weight(x)-weight(y));
        }else{
            System.out.println("?");
        }
    }
    //在union之前更新x到y的距离为多一个c
    public static void relate(int x,int y,int c){
       int fx=find(x);
       int fy=find(y);
       if(fx!=fy){
           //更新a根节点到b根节点的值
           weight[fx]=weight[y]+c-weight[x];
           //连接a、b节点
           //fx到fy的距离等于x到y的距离加上y到fy的距离减去x到fx的距离
           f[fx]=fy;
       }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        for(int i = 0 ; i < n ; i++) {
            f[i] = i;
        }
        int com, x, y, z;
        for(int i = 0 ; i < q ; i++) {
            com = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
            if(com == 0) {
                z = sc.nextInt();
                relate(x, y, z);
            } else diff(x,y);
        }
    }
}
