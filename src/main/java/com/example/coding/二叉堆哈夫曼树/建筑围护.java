package com.example.coding.二叉堆哈夫曼树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 16:01
 * @Version 1.0
 * @description:
 */
public class 建筑围护 {
    //https://gypsophila.blog.luogu.org/solution-p4053
    static int MAXN=200200;
    static int n;
    static int T;//T指遍历时经过了多久时间
    static int ans;
    static class  Node implements Comparable<Node>
    {
        int w; //这个是题解中的ai
        int t;

        @Override
        public int compareTo(Node o) {
            return this.t-o.t;
        }
    }
    static Node a[]=new Node[MAXN];
    static PriorityQueue<Integer> Q=new PriorityQueue<>((Integer a,Integer b)->{
        return b-a;
    });//优先队列

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        String s[];
        for(int i = 1; i <= n; i++)
            {   s=sc.readLine().split(" ");
                a[i]=new Node();
                a[i].w=Integer.parseInt(s[0]);
                a[i].t=Integer.parseInt(s[1]);
            }
        Arrays.sort(a,1,n + 1);
        for(int i = 1; i <= n; i++)
        {
            if(T + a[i].w > a[i].t)//如果无法修复此楼
            {
                if(a[i].w < Q.peek())//ai < aj
                {   //相当于之前那个花时间久修的楼换成修这个花时间少的楼了ans不需要--
                    T -= Q.poll();//注意这里要减掉
                    Q.add(a[i].w);
                    T += a[i].w;
                }
            }
            else
            {
                Q.add(a[i].w);
                ans++;
                T += a[i].w;
            }
        }
        PrintWriter out=new PrintWriter(System.out);
        out.printf("%d\n", ans);
        out.close();
    }
}
