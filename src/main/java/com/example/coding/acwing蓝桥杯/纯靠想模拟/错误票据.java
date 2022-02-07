package com.example.coding.acwing蓝桥杯.纯靠想模拟;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/12/18 15:41
 * @Version 1.0
 * @description:
 */
public class 错误票据 {
    static int map[]=new int[100005];
    public static void main(String[] args) throws IOException {
        Arrays.fill(map,0);
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(sc.readLine().trim());
        int max=Integer.MIN_VALUE;
        while (n-->0){
            String s[]=sc.readLine().split(" ");
            for(int i=0;i<s.length;i++){
                int num=Integer.parseInt(s[i]);
                map[num]++;
                max=Math.max(num,max);

            }
        }
        int a=-1,b=-1;
        for(int i=1;i<=max;i++){
            if(map[i]>=2){
                b=i;
            }
            if(map[i]==0){
                a=i;
            }
        }
        System.out.println(a+" "+b);
    }
}
