package com.example.coding.图论.最小生成树;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/5 23:25
 * @Version 1.0
 * @description:
 */
public class 并查集和最小生成树 {
    static Edge edges[]=new Edge[100001];
    static int n;
    static int tot=0;
    static int f[]=new int[100001];
    public static int find(int x){
        if(x==f[x]){
            return x;
        }
        return f[x]=find(f[x]);//返回和压缩路径
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int x=sc.nextInt();
                //对称矩阵防止重复边
                if(i>j){
                    edges[++tot]=new Edge(i,j,x);
                }
            }
        }
        //初始化并查集
        for(int i=1;i<=n;i++){
            f[i]=i;
        }
        //kurskal
        //java右端点不包括
        Arrays.sort(edges,1,tot+1);//这边注意排序的长度问题 我以为只有n个数字导致无法得到正确结果
        int ans=0;
        for(int i=1;i<=tot;i++){
            int from=edges[i].a;
            int to=edges[i].b;
            int a=find(from);
            int b=find(to);
            if(a!=b){//当前两个节点还没有连在一起
                ans+=edges[i].w;
                f[b]=a;
            }
        }
        System.out.println(ans);

    }
}
    class Edge implements Comparable<Edge> {
        int a, b, w;

        Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO 自动生成的方法存根
            return Integer.compare(w, o.w);
        }
    }
