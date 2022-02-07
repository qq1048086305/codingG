package com.example.coding.二叉堆哈夫曼树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 15:11
 * @Version 1.0
 * @description:
 */
public class 中位数 {
    //https://www.luogu.com.cn/blog/SeanMoe/solution-p1168
    static PriorityQueue<Integer> A=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });//大根堆
    static PriorityQueue<Integer>B=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });//小跟对

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sc.readLine().trim());
        PrintWriter out=new PrintWriter(System.out);
        String s[]=sc.readLine().split(" ");
        A.add(Integer.parseInt(s[0]));
        out.println(A.peek());
        for (int i=2;i<=n;i++){
            int input=Integer.parseInt(s[i-1]);//接下来要加入的数
            if (input>A.peek()) B.add(input);//加到小定堆里
            else A.add(input);//加到大顶堆
            while (Math.abs(A.size()-B.size())>1)//如果AB顶堆元素数量个数大于1
                if (A.size()>B.size()){B.add(A.poll());}//如果大顶堆元素多 把大顶堆的加到小定堆里反之一样
                else{A.add(B.poll());}
            if (i%2==1) {
                out.println(A.size()>B.size()?A.peek():B.peek());
            }
        }
        out.flush();
    }
}
