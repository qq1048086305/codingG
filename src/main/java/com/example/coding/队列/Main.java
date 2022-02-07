package com.example.coding.队列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 21:13
 * @Version 1.0
 * @description:
 */
public class Main {
    /**
     *
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s1[]=sc.readLine().split(" ");
        int n=Integer.parseInt(s1[0]);
        int limit=Integer.parseInt(s1[1]);
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            String s2[]=sc.readLine().split(" ");
            String s=s2[0];
            int time;
            time=Integer.parseInt(s2[1]);
            q.add(new Pair(s,time));
        }
        int ans=0;
        while (!q.isEmpty()){
            Pair pair=q.peek();
            String s=pair.s;
            int time=pair.time;
            if(limit>=time){
                ans+=time;
                q.poll();
                System.out.println(s+" "+ans);
            }else{
                int time2=time-limit;
                ans+=limit;
                q.poll();
                q.add(new Pair(s,time2));
            }
        }
    }
    static class Pair{
        String s;
        int time;
        public Pair(String s, int time) {
            this.s = s;
            this.time = time;
        }
    }
}

