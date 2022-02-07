package com.example.coding.AOJ刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/12/3 13:06
 * @Version 1.0
 * @description:
 */
public class AOJ0585 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sc.readLine().trim());
        Point p[]=new Point[n];
        for(int i=0;i<n;i++){
            String[] s = sc.readLine().split(" ");
            p[i]=new Point(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }
        Arrays.sort(p);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                //可行性剪枝条
                if((p[i].x-p[j].x)*(p[i].x-p[j].x)>=ans){
                    break;
                }
                ans=Math.min(getDis(p[i],p[j]),ans);
            }
        }
        System.out.println(ans);
    }
    public static int getDis(Point p1,Point p2){
        return (p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y);
    }
    public static class Point implements Comparable<Point>{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x-o.x;
        }
    }
}
