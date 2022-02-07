package com.example.coding.贪心;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/6 15:59
 * @Version 1.0
 * @description:
 */
public class 值班表 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sc.readLine().trim());
        Pair pair[]=new Pair[n+1];
        int cnt=1;
        while (n-->0){
            String[] split = sc.readLine().split("\\s+");
            pair[cnt++]=new Pair(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
        }
        Arrays.sort(pair,1,cnt);
        int ans=1;
        Pair pre=pair[1];
        for(int i=2;i<cnt;i++){
            if(pair[i].start>pre.end){
                pre=pair[i];
                ans++;
            }else{
                continue;
            }
        }
        System.out.println(ans);
    }
}
 class Pair implements Comparable<Pair>{
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
        return this.end-o.end;
    }
}
