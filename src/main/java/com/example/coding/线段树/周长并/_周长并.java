package com.example.coding.线段树.周长并;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/9 22:37
 * @Version 1.0
 * @description:
 */
public class _周长并 {
    static int N = 10005;
    static int n, x1, x2, y1 ,y2;
    static boolean[] lCover = new boolean[N << 2];
    static boolean[] rCover = new boolean[N << 2];
    static int[] sum = new int[N << 2];
    static int[] len = new int[N << 2];
    static int[] cnt = new int[N << 2];//保存线段的条数
    static int[] X = new int[N << 1];
    static Line1[] line = new Line1[N << 1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int tem = 1;
        for (int i = 1; i <= n; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            X[tem] = x1;
            line[tem++] = new Line1(x1, x2, y1, 1);
            X[tem] = x2;
            line[tem++] = new Line1(x1, x2, y2, -1);
        }
        n <<= 1;
        Arrays.sort(X, 1, n | 1);
        Arrays.sort(line, 1, n | 1);
        X[0] = -99999;
        tem = 0;
        //去重  离散化
        for (int i = 1; i <= n; i++) {
            if (X[i] != X[tem]) {
                X[++tem] = X[i];
            }
        }
        long ans = 0;
        long last = 0;
        line[n + 1] = new Line1(0, 0, 0, 0);
        for (int i = 1; i <=n ; i++) {
            int xx = low_bound(1, tem, line[i].l);
            int yy = low_bound(1, tem, line[i].r);
            //yy - 1 是因为线段树维护的是区间 yy是当前点的下标,同理tem-1
            update(1, 1, tem - 1, xx, yy - 1, line[i].w);
            ans += abs(len[1] - last);
            ans += cnt[1] * 2 * (line[i + 1].h - line[i].h);
            last = len[1];
        }
        System.out.println(ans);
    }
    static long abs(long a) {
        if (a > 0) {
            return a;
        } else {
            return -a;
        }
    }
    static int low_bound(int l, int r, int v) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (X[mid] >= v) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    // 这个函数最关键  其他都是套模板
    static void pushup(int id, int l, int r) {
        int lId = id << 1;
        int rId = id << 1 | 1;
        if (sum[id] > 0) {
            len[id] = X[r + 1] - X[l];
            lCover[id] = rCover[id] = true;
            cnt[id] = 1;
        } else if (l == r) {
            len[id] = 0;
            cnt[id] = 0;
            lCover[id] = rCover[id] = false;
        } else {
            len[id] = len[lId] + len[rId];
            lCover[id] = lCover[lId];
            rCover[id] = rCover[rId];
            //减去1 是因为可能会凑成一条线段 ， 凑成一条线段有2种可能 一种是左右区间全部覆盖，一种是左区间的右子区间覆盖和右区间的左子区间覆盖， 2种情况都可以写成下面一种。
            cnt[id] = cnt[lId] + cnt[rId] - (lCover[rId] && rCover[lId] ? 1 : 0);
        }
    }

    static void update(int id, int l, int r, int x, int y, int v) {
        if (x <= l && r <= y) {
            sum[id] += v;
            pushup(id, l, r);
            return;
        }
        int mid = (l + r) >> 1;
        if (x <= mid) {
            update(id << 1, l, mid, x, y, v);
        }
        if (y > mid) {
            update(id << 1 | 1, mid + 1, r, x, y, v);
        }
        pushup(id, l, r);
    }

}
class Line1 implements Comparable<Line1>{
    int l, r, h, w;
    public Line1(int l, int r, int h, int w) {
        this.l = l;
        this.r = r;
        this.h = h;
        this.w = w;
    }
    public int compareTo(Line1 o) {
        return h - o.h;
    }
}