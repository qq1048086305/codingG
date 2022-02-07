package com.example.coding.搜索.宽搜;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/15 8:06
 * @Version 1.0
 * @description:
 */
public class 吃奶酪 {


    static Queue<Pair> queue=new LinkedList<>();
    static int map[][]=new int [15][15];
    static int st[][]=new int [15][15];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a,b;
            a=sc.nextInt();
            b=sc.nextInt();
            map[a][b]=1;
        }
        queue.add(new Pair(0,0,0));

    }
    static double getDis(int x1,int y1,int x2,int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    static class Pair{
        int x,y;
        double dis;

        public Pair(int x, int y, double dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
