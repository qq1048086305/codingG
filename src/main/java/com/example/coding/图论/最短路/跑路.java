/*
package com.example.coding.图论.最短路;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

*/
/**
 * @Author 神様だよ
 * @Date 2021/11/6 12:06
 * @Version 1.0
 * @description:
 *//*

@SuppressWarnings("unchecked")
public class 跑路 {
    static int INF=0x3f3f3f3f;
    static int N=10005;
    static int n,m,c;
    static boolean st[]=new boolean[N];
    static int dist[]=new int[N];
    static int num[]=new int[N];
    static List<Integer> list[]=new List[N];
    public static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < list.length; i++) {
            list[i]=new ArrayList<>();
        }
        n=sc.nextInt();
        m=sc.nextInt();
        for(int i=0;i<m;i++){
            int u=sc.nextInt();//顶点编号
            int k=sc.nextInt();//3个边
            list[u].add(k);
        }
        spfa(0);
        for(int i=0;i<n;i++){
            System.out.println(i+" "+dist[i]);
        }
    }

    private static void spfa(int start) {
        LinkedList<Integer> que=new LinkedList<Integer>();
        Arrays.fill(dist,INF);
        Arrays.fill(st,false);
        dist[start]=0;
        que.add(start);
        st[start]=true;
        while (!que.isEmpty()){
            Integer t = que.poll();
            st[t]=false;
            for(int i=0;i<list[t].size();i++){
                */
/**//*
Edge edge = list[t].get(i);
                int to=edge.to;
                int weight=edge.weight;
                //当前从起点到to的距离大于 从to的父节点来的这条距离，更新
                if(dist[to]>dist[t]+weight){
                    dist[to]=dist[t]+weight;
                    if(!st[to]){
                        st[to]=true;
                        if(que.isEmpty()){
                            que.add(to);
                        }else{
                            if(dist[to]>dist[que.peekFirst()]){
                                que.addLast(to);
                            }else{
                                que.addFirst(to);
                            }
                        }
                    }
                }
            }
        }
    }
}
*/
