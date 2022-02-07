package com.example.coding.AOJ刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 9:29
 * @Version 1.0
 * @description:
 */
public class ICPCScoreTotalizerSoftware {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        while (true){
            int n=getInt(sc.readLine().trim());
            if(n==0){
                return;
            }
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            int total=0;
            for(int i=0;i<n;i++){
                int x=getInt(sc.readLine().trim());
                min=Math.min(x,min);
                max=Math.max(x,max);
                total+=x;
            }
            total-=(max+min);
            out.println(total/(n-2));
            out.flush();
        }
    }
    public static Integer getInt(String s){
        return Integer.parseInt(s);
    }
}
