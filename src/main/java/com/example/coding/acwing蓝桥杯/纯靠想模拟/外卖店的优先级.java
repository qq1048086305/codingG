package com.example.coding.acwing蓝桥杯.纯靠想模拟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Author 神様だよ
 * @Date 2021/12/18 16:23
 * @Version 1.0
 * @description:
 */
public class 外卖店的优先级 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int N,M,T;
        String s[]=sc.readLine().split(" ");
        N=Integer.parseInt(s[0]);
        M=Integer.parseInt(s[1]);
        T=Integer.parseInt(s[2]);
        PriorityQueue<Point> pq=new PriorityQueue<>();
        //以下 M 行每行包含两个整数 ts 和 id，表示 ts 时刻编号 id 的外卖店收到一个订单。
        for(int i=0;i<M;i++){
            s=sc.readLine().split(" ");
            Point temp=new Point();
            temp.x=Integer.parseInt(s[0]);
            temp.y=Integer.parseInt(s[1]);
            pq.add(temp);
        }
        int a[]=new int[N+1];
        HashSet<Integer> ans =new HashSet<>();
        for(int i=1;i<=T;i++){
            //一个for只能减一次
            boolean flag[]=new boolean[N+1];
            while (!pq.isEmpty()){
                Point poll = pq.poll();
                int curTime=poll.x;
                if(curTime>i){
                    pq.add(poll);
                    break;
                }
                a[poll.y]+=2;
                if(a[poll.y]>5){
                    ans.add(poll.y);
                }
                flag[poll.y]=true;
            }
            for(int j=1;j<=N;j++){
                if(!flag[j]){
                    int temp=a[j];
                    a[j]=temp-1>=0?temp-1:0;
                    if(a[j]<=3){
                        ans.remove(j);
                    }
                }
            }
        }
        System.out.println(ans.size());
    }
    static class Point implements Comparable<Point>{
        int x,y;

        @Override
        public int compareTo(Point o) {
            return this.x-o.x;
        }
    }
}
