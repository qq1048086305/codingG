package com.example.coding.数组型线段树.离散化扫描线;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class 矩形切割 {
    static int n, cnt = 1;
    static int N = 105;
    static double x1, x2, y1, y2;
    static double[] X = new double[N << 1];
    static double[] len = new double[N << 4]; //因为有2N个点
    static int[] sum = new int[N << 4];
    static Line[] line = new Line[N << 1];
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        Scanner sc = new Scanner(new  InputStreamReader(System.in));
        while (sc.hasNext()) {
            Arrays.fill(len, 0);
            Arrays.fill(sum, 0);
            n = sc.nextInt();
            if (n == 0) break;
            out.println("Test case #" + cnt++);
            for (int i = 1; i <= n; i++) {
                x1 = sc.nextDouble();
                y1 = sc.nextDouble();
                x2 = sc.nextDouble();
                y2 = sc.nextDouble();
                line[i * 2 - 1] = new Line(x1, x2, y1, 1);
                line[i * 2] = new Line(x1, x2, y2, -1);
                X[i * 2 - 1] = x1;
                X[i * 2] = x2;
            }
            n <<= 1;
            Arrays.sort(X, 1, n | 1);
            Arrays.sort(line, 1, n | 1);
            //对X去重操作
            int tem = 0;
            X[0] = -1; //这步很关键
            for (int i = 1; i <= n; i++) {
                if (X[i] != X[tem]) {
                    X[++tem] = X[i];
                }
            }
            double ans = 0;
            for (int i = 1; i < n; i++) {
                int l = low_bound(1, tem, line[i].l);  //二分查找当前值在线段树中代表的点
                int r = low_bound(1, tem, line[i].r);
                update(1, 1, tem - 1, l, r - 1, line[i].w);
                ans += len[1] * (line[i + 1].h - line[i].h);
            }
            out.printf("Total explored area: %.2f\n\n", ans);
        }
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