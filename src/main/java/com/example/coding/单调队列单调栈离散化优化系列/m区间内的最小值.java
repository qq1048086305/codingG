package com.example.coding.单调队列单调栈离散化优化系列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 13:13
 * @Version 1.0
 * @description:
 */
public class m区间内的最小值 {
    static int maxsize = 2000010;
    static int n,m;
    static int A[]=new int[maxsize];
    static LinkedList<Integer> min_Q=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String[] s = sc.readLine().split(" ");
        PrintWriter out=new PrintWriter(System.out);
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        s=sc.readLine().split(" ");
        for(int i = 1;i <= n;i++)
        {
            A[i] = Integer.parseInt(s[i-1]);
        }
        out.printf("%d\n",0);
        for(int i = 1;i < n;i++)
        {   while(!min_Q.isEmpty()&&min_Q.peekFirst()<= i - m)
            min_Q.pollFirst();
            while(!min_Q.isEmpty()&&A[min_Q.peekLast()]>= A[i])
                min_Q.pollLast();
            min_Q.addLast(i);
            out.printf("%d\n",A[min_Q.peekFirst()]);
        }
        out.flush();
    }
}
