package com.example.coding.搜索.启发式搜索;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 14:13
 * @Version 1.0
 * @description:
 */
public class 机关 {
    static class Node
    {
        int fx[]=new int[13];
        int num;
        int h;
        int stand;
    }
    static PriorityQueue<Node> pq=new PriorityQueue<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return (o2.num+o2.h)-(o1.num+o1.h);
        }
    });
    static int inp[][]=new int[13][5];
    static Stack<Integer>ans=new Stack<> ();
    static int fa[]=new int[70000000];
    static int flag[]=new int[70000000];
    static boolean vis[]=new boolean[70000000];
    static void con(Node a)
    {
        int kk = 0;
        for (int i = 1; i <= 12; i++)
        {
            if (a.fx[i] != 1)
                kk += 5 - a.fx[i];
        }
        a.h = ((kk - 1) >> 1) + 1;
    }
    static int _next(int x)
    {
        return x==4?1:x+1;
    }

    public static void main(String[] args) {
        Node now=new Node();
        PrintWriter out=new PrintWriter(System.out);
        Scanner sc=new Scanner(System.in);
        for (int i = 1; i <= 12; i++) {
            now.fx[i] = sc.nextInt();
            inp[i][1] = sc.nextInt();
            inp[i][2] = sc.nextInt();
            inp[i][3] = sc.nextInt();
            inp[i][4] = sc.nextInt();
        }
        now.num = 0;
        con(now);
        pq.add(now);
        while (!pq.isEmpty())
        {
            Node from = pq.poll();
            if (from.h == 0)
            {
                out.printf("%d\n", from.num);
                int noww = from.stand;
                for (int i = 1; i <= from.num; i++)
                {
                    ans.push(flag[noww]);
                    noww = fa[noww];
                }
                for (int i = 1; i <= from.num; i++)
                {
                    out.printf("%d ", ans.pop());
                }
                return ;
            }
            for (int i = 1; i <= 12; i++)
            {
                Node to = new Node();
                to.num=from.num+1;
                to.fx[inp[i][from.fx[i]]]=_next(from.fx[inp[i][from.fx[i]]]);
                to.fx[i]=_next(from.fx[i]);

                int standd = 0;
                for (int j = 1; j <= 12; j++)
                {
                    standd = (standd<<2) + to.fx[j];
                }
                if (vis[standd])
                    continue;
                vis[standd]=true;
                to.stand = standd;
                fa[standd] = from.stand;
                flag[standd] = i;
                con(to);
                pq.add(to);
            }
        }
        out.flush();

    }
}
