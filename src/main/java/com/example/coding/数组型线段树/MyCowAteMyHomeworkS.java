package com.example.coding.数组型线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.zip.InflaterInputStream;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 16:50
 * @Version 1.0
 * @description:
 */
public class MyCowAteMyHomeworkS {
    /**
     * 使用线段树来维护区间最小值和区间和，枚举k值，统计答案。
     *
     * 每次枚举的k，如果使得平均成绩大于当前最大平均成绩，就更新当前的最大平均成绩，清空答案数组，放入这个k值。
     *
     * 如果这次平均成绩等于当前最大平均成绩，那么直接把k值加入答案数组。
     */
    static int N=100010;
    static int n;
    static int sum[]=new int[N<<2],Min[]=new int[N<<2];
    static int a[]=new int[N<<2];
    static int s,minn;
    static double last;
    static PrintWriter out=new PrintWriter(System.out);
    static Vector<Integer> ans=new Vector<>();
    static void build(int i,int l,int r)
    {
        if(l==r)
        {
            sum[i]=Min[i]=a[l];
            return;
        }
        int mid=l+r>>1;
        build(i<<1,l,mid);
        build(i<<1|1,mid+1,r);
        sum[i]=sum[i<<1]+sum[i<<1|1];
        Min[i]=Math.min(Min[i<<1],Min[i<<1|1]);
    }
    static void query(int i,int l,int r,int x,int y)
    {
        if(l>=x&&r<=y)
        {
            s+=sum[i];
            minn=Math.min(minn,Min[i]);
            return;
        }
        int mid=l+r>>1;
        if(x<=mid)query(i<<1,l,mid,x,y);
        if(y>mid) query(i<<1|1,mid+1,r,x,y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(sc.readLine().trim());
        String ss[]=sc.readLine().split(" ");
        for(int i=1;i<=n;i++){
            a[i]=Integer.parseInt(ss[i-1]);
        }
        build(1,1,n);
        //枚举k的值
        for(int k=1;k<=n-2;k++)
        {
            // k+1  ->  n
            minn=Integer.MAX_VALUE/2;
            s=0;
            //去线段树里面拿当前区间的值
            query(1,1,n,k+1,n);
            double score=(s-minn)*1.0/(double)(n-k-1);
            if(score>last)
            {
                ans.clear();
                ans.add(k);
                last=score;
            }
            else if(score==last)
            {
                ans.add(k);
            }
        }
        for(int i:ans)
        {
            out.printf("%d\n",i);
        }
        out.flush();
    }
}
