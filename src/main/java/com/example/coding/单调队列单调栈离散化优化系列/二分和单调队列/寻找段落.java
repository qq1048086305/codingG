package com.example.coding.单调队列单调栈离散化优化系列.二分和单调队列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 15:58
 * @Version 1.0
 * @description:
 */
public class 寻找段落 {
    static int  N=100101;
    static int n;
    static int S,T,a[]=new int[N];
    static double sum[]=new double[N];
    static LinkedList<Integer> que=new LinkedList<>();
    static boolean check(double k) {
        int i, p;
        //前缀和
        que.clear();
        for (i = 1; i <= n; ++i) sum[i] = sum[i - 1] + a[i] * 1.0 - k;
        for (i = S, p = 0; i <= n; ++i, ++p) {
            while (!que.isEmpty() && i - que.peekFirst() > T) que.pollFirst();
            while (!que.isEmpty() && sum[que.peekLast()] > sum[p]) que.pollLast();
            que.addLast(p);
            if (sum[i] - sum[que.peekFirst()] >= 0) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        String s[]=sc.readLine().split(" ");
        S=Integer.parseInt(s[0]);
        PrintWriter out=new PrintWriter(System.out);
        T=Integer.parseInt(s[1]);
        int i;
        for(i=1;i<=n;++i)
            a[i]=Integer.parseInt(sc.readLine().trim());
        double l=-1e4,r=1e4,mid;
        while(r-l>1e-4){
            mid=(l+r)/2;
            if(check(mid))l=mid;
            else r=mid;
        }
        out.printf("%.3f\n",l);
        out.flush();
    }
}
