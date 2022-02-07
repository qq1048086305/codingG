package com.example.coding.二叉堆哈夫曼树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 15:31
 * @Version 1.0
 * @description:
 */
public class 最小函数值 {
    //https://www.luogu.com.cn/blog/zhutier23333/solution-p2085
    static PriorityQueue<Integer> q=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });//大根堆
    static int n,m,a,b,c,ans[]=new int[100005];

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        PrintWriter out=new PrintWriter(System.out);
        for(int i=1;i<=n;i++){
            s=sc.readLine().split(" ");
            a=Integer.parseInt(s[0]);
            b=Integer.parseInt(s[1]);
            c=Integer.parseInt(s[2]);
            for(int j=1;j<=m;j++){
                int k;
                k=a*j*j+b*j+c;//k为函数值y
                if(i==1) q.add(k);
                else{
                    if(k<q.peek()){
                        q.add(k);
                        q.poll();
                    }
                    else break;
                    //如果k已经大于第m小的数了，接下来k仍旧单调递增
                    //所以可以直接break掉，一个重要的优化
                }
            }
        }
        for(int i=1;i<=m;i++){
            ans[i]=q.poll();
        }//记得要逆着输出！
        for(int i=m;i>=1;i--)
            out.printf("%d ",ans[i]);
        out.flush();
    }
}
