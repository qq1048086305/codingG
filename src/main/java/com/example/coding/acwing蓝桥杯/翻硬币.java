package com.example.coding.acwing蓝桥杯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 神様だよ
 * @Date 2021/12/10 18:48
 * @Version 1.0
 * @description:
 */
public class 翻硬币 {
    public static void main(String[] args) throws IOException {
        Queue<Pair> q=new LinkedList<>();
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String start = sc.readLine();
        HashSet<String> set=new HashSet<>();
        String end=sc.readLine();
        q.add(new Pair(start,0));
        set.add(start);
       /* while (!q.isEmpty()){
            Pair pair=q.poll();
            char cur[]=pair.s.toCharArray();
            int curStep=pair.step;
            if(new String(cur).equals(end)){
                System.out.println(curStep);
                return;
            }
            for(int i=0;i<cur.length-1;i++){
                turn(cur,i);
                turn(cur,i+1);
                String to=new String(cur);
                if(!set.contains(to)){
                    q.add(new Pair(to,curStep+1));
                    set.add(to);
                }
                //换回来
                turn(cur,i);
                turn(cur,i+1);
            }*/
       char str1[]=start.toCharArray();
       char str2[]=end.toCharArray();
       int ans=0;
       for(int i=0;i<str1.length;i++){
           if(str1[i]!=str2[i]){
               turn(str1,i);
               turn(str1,i+1);
               ans++;
           }
        }
        System.out.println(ans);

    }

    private static void turn(char[] cur, int i) {
        if(cur[i]=='*'){
            cur[i]='o';
        }else{
            cur[i]='*';
        }
    }

    public static class Pair{
        String s;
        int step;

        public Pair(String s, int step) {
            this.s = s;
            this.step = step;
        }
    }
}
