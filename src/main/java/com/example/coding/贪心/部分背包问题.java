package com.example.coding.贪心;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/12 22:19
 * @Version 1.0
 * @description:
 */
public class 部分背包问题 {
    /**
     * 这道题的价值可以精确到单位重量对应的价值
     * @param args
     */
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            double m=sc.nextDouble();
            Node nodes[]=new Node[n+1];
            for(int i=1;i<=n;i++ ){
                Double a,b;
                a=sc.nextDouble();
                b=sc.nextDouble();
                nodes[i]=new Node(a,b);
            }
            Arrays.sort(nodes,1,n+1);
            double ans=0;
            for(int i=1;i<=n;i++){
                if(m>nodes[i].m){
                    ans+=nodes[i].v;
                    m-=nodes[i].m;
                }else{
                    ans+=m*nodes[i].p;break;
                }
            }
        System.out.printf("%.2f",ans);


    }
    public static class Node implements Comparable<Node>{
        Double m,v,p;

        public Node(Double m,Double v) {
            this.m = m;
            this.v = v;
            this.p = v/m;//每斤对应的价值
        }

        @Override
        public int compareTo(Node o) {
            return o.p.compareTo(this.p);
        }
    }
}
