package com.example.coding.树状数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 9:25
 * @Version 1.0
 * @description:
 */
public class 火柴排队 {
    //变相求逆序对
    static int maxm = 99999997;
    static int tree[]=new int[100010],rank[]=new int[100010],n;
    static long ans;
    static class Point implements Comparable<Point>
    {
        int num,val;

        @Override
        public int compareTo(Point o) {
            if(this.val==o.val){
                return this.num-o.num;
            }else{
                return this.val-o.val;
            }
        }
    }
    static Point a[]=new Point[100010];
    static Point b[]=new Point[100010];
    static void insert(int p,int d)
    {
        for(;p<=n;p+=p&-p)
            tree[p]+=d%maxm;
    }
    static int query(int p)
    {
        int sum=0;
        for(;p>0;p-=p&-p)
            sum+=tree[p]%maxm;
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        String[] s = sc.readLine().split(" ");
        for(int i=1;i<=n;i++)
        {   a[i]=new Point();
            a[i].val=Integer.parseInt(s[i-1]);
            a[i].num=i;
        }
        s = sc.readLine().split(" ");
        for(int i=1;i<=n;i++)
        {   b[i]=new Point();
            b[i].val=Integer.parseInt(s[i-1]);
            b[i].num=i;
        }
        //按价值排序
        Arrays.sort(a,1,1+n);
        Arrays.sort(b,1,1+n);
        for(int i=1;i<=n;i++)
            //离散化数组 保存的是数的相对大小 比如第一个数在原数组中第几大
            rank[a[i].num]=b[i].num;
        for(int i=1;i<=n;i++)
        {
            insert(rank[i],1);
            ans+=i-query(rank[i]);
            ans%=maxm;
        }
        System.out.printf("%d",ans);
    }
}
