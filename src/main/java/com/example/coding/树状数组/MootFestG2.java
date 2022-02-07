package com.example.coding.树状数组;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 9:46
 * @Version 1.0
 * @description:
 */
public class MootFestG2 {
    static int N = 20005;
    static long ll,ans;

    static int n,cnt;
    static long iAns, iSum[]=new long[N], iCnt[]=new long[N];
    static class sCow implements Comparable<sCow>
    {
        int V, X;

        @Override
        public int compareTo(sCow o) {
            return this.V-o.V;
        }
    }
    static sCow cow[]=new sCow[N];
    static int lowbit(int x){return x & -x;}
    static void Add(int x, int k){
        for(; x <= N; x += lowbit(x)) {
            iSum[x] += k; iCnt[x] += 1;
        }
    }
    static void Query(int x){
        ans = 0;
        cnt = 0;
        for(; x>0; x -= lowbit(x))
            ans += iSum[x];
            cnt += iCnt[x];
       }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i = 1; i <= n; i++){
            cow[i]=new sCow();
            cow[i].V=sc.nextInt();
            cow[i].X=sc.nextInt();
        }
        Arrays.sort(cow,1,  1 + n);
        long S = 0, C = 0;
        for(int i = 1; i <= n; i++)
        {
            ans = 0;
            cnt = 0;
            Query(cow[i].X);
            iAns += cow[i].V * (cnt * cow[i].X - ans);
            iAns += cow[i].V * ((S - ans) - (C - cnt) * cow[i].X);
            Add(cow[i].X, cow[i].X);
            S += cow[i].X;
            C +=1;
        }
        System.out.println(iAns);
    }
}
