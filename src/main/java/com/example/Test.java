package com.example;

import com.example.coding.线段树.RMQRUQ;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author 神様だよ
 * @Date 2021/11/6 13:24
 * @Version 1.0
 * @description:
 */
public class Test {
    static int n, cnt = 1;
    static int N = 2005;
    static double x1, x2, y1, y2;
    static double[] X = new double[N << 1];
    static Line[] line = new Line[N << 1];
    static double[] len = new double[N << 4]; //因为有2N个点
    static int[] sum = new int[N << 4];
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        //while (sc.hasNext()) {
        Arrays.fill(len, 0);
        Arrays.fill(sum, 0);
        n = sc.nextInt();
        //if (n == 0) break;
        //out.println("Test case #" + cnt++);
        int tot=0;
        for (int i = 1; i <= n; i++) {
            //输入矩形的左上角右下角
            x1 = sc.nextDouble();
            y1 = sc.nextDouble();
            x2 = sc.nextDouble();
            y2 = sc.nextDouble();
            //保存两条边 矩形上边下边
            line[i * 2 - 1] = new Line(x1, x2, y1, 1);
            line[i * 2] = new Line(x1, x2, y2, -1);
            //保存对应的横坐标
            X[i * 2 - 1] = x1;
            X[i * 2] = x2;
        }
        //对X排序
        Arrays.sort(X, 1, n | 1);
        //对边根据高排序
        Arrays.sort(line, 1, n | 1);
        //对X去重操作
        int tem = 0;
        X[0] = -1; //这步很关键
        for (int i = 1; i <= n; i++) {
            if (X[i] != X[tem]) {
                X[++tem] = X[i];
            }
        }
        Segment segment=new Segment();
        segment.build(1,1,tem*5);
       /* double ans = 0;
        for (int i = 1; i < n; i++) {

            int l = low_bound(1, tem, line[i].l);  //二分查找当前值在线段树中代表的点
            int r = low_bound(1, tem, line[i].r);
            //yy - 1 是因为线段树维护的是区间 yy是当前点的下标,同理tem-1
            update(1, 1, tem - 1, l, r - 1, line[i].w);
            ans += len[1] * (line[i + 1].h - line[i].h);
        }*/
        double ans = 0;
        for (int i = 1; i < n; i++) {
            //二分查找在离散数组对应的点
            int l = low_bound(1, tem, line[i].l);  //二分查找当前值在线段树中代表的点
            int r = low_bound(1, tem, line[i].r);
            //yy - 1 是因为线段树维护的是区间 yy是当前点的下标,同理tem-1
            segment.update(1,  l, r , line[i].w);
            ans += segment.tr[1].len * (line[i + 1].h - line[i].h);
        }
        out.println((int)ans);
        // }
        out.close();
    }
    static int low_bound(int l, int r, double x) {
        while (l < r){
            int mid = (l + r) >> 1;
            if(X[mid]>=x){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    static void pushup(int id, int l, int r) {
        if(sum[id] > 0) {
            len[id] = X[r + 1] - X[l];
        }  else {
            len[id] = len[id << 1] + len[id << 1 | 1];
        }
    }
    static void update(int id, int l, int r, double x, double y, int v) {
        if (x <= l && r <= y) {
            //在这个区间
            sum[id] += v;
            pushup(id, l, r);
            return;
        }
        int mid = (l + r) >> 1;
        if (x <= mid) {
            update(id << 1, l, mid, x, y, v);
        }
        if (y > mid){
            update(id << 1 | 1, mid + 1, r, x, y, v);
        }
        pushup(id, l, r);
    }
    static class Segment{
        Node tr[]=new Node[500];
        void pushup(int id) {
            int l=tr[id].l;
            int r=tr[id].r;
            if(sum[id] > 0) {
                tr[id].len = X[r + 1] - X[l];
            }  else {
                tr[id].len = tr[id << 1].len + tr[id << 1 | 1].len;
            }
        }
         void update(int id, double x, double y, int v) {
            if (x <= tr[id].l && tr[id].r <= y) {
                //在这个区间
                tr[id].sum+=v;
                pushup(id);
                return;
            }
            int mid = (tr[id].l + tr[id].r) >> 1;
            if (x <= mid) {
                update(id << 1, x, y, v);
            }
            if (y > mid){
                update(id << 1 | 1,  x, y, v);
            }
            pushup(id);
        }
         void build(int p,int l,int r){
            tr[p] = new Node(l, r, 0,0);
            if(l == r) {
                //tr[p].add=0;
                return ;
            }
            int mid = l + r >> 1;
            build(2*p, l, mid);
            build(2*p+1, mid + 1, r);
            //pushup(p);
        }
    }
    static class Node{
        int l,r;

        public Node(int l, int r, double sum, double len) {
            this.l = l;
            this.r = r;
            this.sum = sum;
            this.len = len;
        }

        double sum,len;

        public Node(double sum, double len) {
            this.sum = sum;
            this.len = len;
        }
    }
}
class Line implements Comparable<Line> {
    double l, r, h;
    int w;
    public Line(double l, double r, double h, int w) {
        this.l = l;
        this.r = r;
        this.h = h;
        this.w = w;
    }
    public int compareTo(Line o) {
        return Double.compare(h, o.h);
    }
}
