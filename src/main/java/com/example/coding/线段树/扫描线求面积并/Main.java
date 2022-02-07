package com.example.coding.线段树.扫描线求面积并;

import javax.swing.text.Segment;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/9 19:20
 * @Version 1.0
 * @description:
 */
public class Main {
    static int n, cnt = 1;
    static int N = 105;
    static double x1, x2, y1, y2;
    static double[] X = new double[N << 1];
    static double[] len = new double[N << 4]; //因为有2N个点 线段树模板
    static int[] sum = new int[N << 4];
    static Line[] line = new Line[N << 1];//2N边
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
            Arrays.fill(len, 0);
            Arrays.fill(sum, 0);
            n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                x1 = sc.nextDouble();
                y1 = sc.nextDouble();
                x2 = sc.nextDouble();
                y2 = sc.nextDouble();
                //保存上下两条边的信息算发模板
                line[i * 2 - 1] = new Line(x1, x2, y1, 1);
                line[i * 2] = new Line(x1, x2, y2, -1);
                //从1开始记录横坐标数组
                X[i * 2 - 1] = x1;
                X[i * 2] = x2;
            }
            //因为有2n个边
            //n变为两倍
            n <<= 1;
            //对X排序用于离散化数组
            Arrays.sort(X, 1, n | 1);
            //对边根据高排序用于计算面积
            Arrays.sort(line, 1, n | 1);
            //对X去重操作
            int tem = 0;
            //离散化
            X[0] = -1; //这步很关键
            for (int i = 1; i <= n; i++) {
                if (X[i] != X[tem]) {
                    X[++tem] = X[i];
                }
            }
            double ans = 0;
            for (int i = 1; i < n; i++) {
                //维护一个[1,tem]长度的线段树
                int l = low_bound(1, tem, line[i].l);  //二分查找当前值在线段树中代表的点
                int r = low_bound(1, tem, line[i].r);
                update(1, 1, tem-1 , l, r-1 , line[i].w);
                ans += len[1] * (line[i + 1].h - line[i].h);
            }
            out.printf("Total explored area: %.2f\n\n", ans);
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
            len[id] = X[r+1] - X[l];
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

