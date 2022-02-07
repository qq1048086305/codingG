package com.example.coding.树状数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 8:28
 * @Version 1.0
 * @description:
 */
public class 逆序对 {
    /**
     * 每次加一个元素a[i]，此时加了i个元素，i-1个元素的位置都在a[i]之前，
     *
     * 然后求sum(a[i])，求出了位置在a[i]之前的，值小于a[i]的元素个数（包括a[i]本身），那么已经插入了i个元素，i-sum(a[i])
     *
     * 就是值大于a[i]的元素的个数
     */
    /**
     * 线段树也可以做
     * 逐个插入数字，当插入x时，查找区间x+1到n的sum，因为，此时在区间内存在的值，
     * 必定在插x之前就插了，所以序号是小于x的序号，但是值又大于x，符合逆序对的定义
     */
    static int tree[]=new int[500010],rank[]=new int[500010],n;
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
    static Point a[]=new Point[500010];
    static void insert(int p,int d)
    {
        for(;p<=n;p+=p&-p)
            tree[p]+=d;
    }
    static int query(int p)
    {
        int sum=0;
        for(;p>0;p-=p&-p)
            sum+=tree[p];
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        String[] s = sc.readLine().split(" ");
        for(int i=1;i<=n;i++)
            {a[i]=new Point();
              a[i].val=Integer.parseInt(s[i-1]);
              a[i].num=i;
            }
        //按价值排序
        Arrays.sort(a,1,1+n);
        for(int i=1;i<=n;i++)
            //离散化数组 保存的是数的相对大小 比如第一个数在原数组中第几大
            rank[a[i].num]=i;
        for(int i=1;i<=n;i++)
        {
            insert(rank[i],1);
            ans+=i-query(rank[i]);
        }
        System.out.printf("%d",ans);
    }
}
