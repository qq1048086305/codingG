package com.example.coding.二叉堆哈夫曼树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 14:49
 * @Version 1.0
 * @description:
 */
public class 黑匣子 {
    static int a[]=new int[200005];

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> A=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });//大根堆
        PriorityQueue<Integer>B=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });//小跟对
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        String s[]=sc.readLine().split(" ");
        int n,m,r=1,q;
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        s=sc.readLine().split(" ");
        for(int i=1;i<=n;i++)a[i]=Integer.parseInt(s[i-1]);
        s=sc.readLine().split(" ");
        for(int i=1;i<=m;i++){
            q=Integer.parseInt(s[i-1]);
            for(int j=r;j<=q;j++){
                A.add(a[j]);
                if(A.size()==i)B.add(A.poll());
            }
            r=q+1;
            out.printf("%d\n",B.peek());
            A.add(B.poll());
        }
        out.flush();
    }
}
