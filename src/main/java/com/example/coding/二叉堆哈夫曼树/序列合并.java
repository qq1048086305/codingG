package com.example.coding.二叉堆哈夫曼树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.zip.InflaterInputStream;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 15:41
 * @Version 1.0
 * @description:
 */
public class 序列合并 {
    //https://www.luogu.com.cn/blog/tb148/solution-p1631
    static PriorityQueue<Integer> q=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    static int n,a[]=new int[100005],b[]=new int[100005],ans[]=new int[100005];

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        String s[]=sc.readLine().split(" ");
        for(int i=1;i<=n;i++){
            a[i]=Integer.parseInt(s[i-1]);
        }
         s=sc.readLine().split(" ");
        for(int i=1;i<=n;i++){
            b[i]=Integer.parseInt(s[i-1]);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int x=a[i]+b[j];
                if(q.size()<n){
                    q.add(x);
                }
                else{
                    if(q.peek()>x){
                        q.poll();
                        q.add(x);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        PrintWriter out=new PrintWriter(System.out);
        for(int i=n;i>=1;i--){
            ans[i]=q.poll();
        }
        for(int i=1;i<=n;i++){
            out.printf("%d ",ans[i]);
        }
        out.close();
    }
}
