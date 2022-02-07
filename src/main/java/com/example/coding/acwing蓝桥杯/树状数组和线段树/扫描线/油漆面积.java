package com.example.coding.acwing蓝桥杯.树状数组和线段树.扫描线;

/**
 * @Author 神様だよ
 * @Date 2021/12/19 17:59
 * @Version 1.0
 * @description:
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 油漆面积 {
    static Node[] tree = new Node[10010 * 4];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Segment[] segments = new Segment[n * 2];
        for (int i = 0; i < 2* n;) {
            String[] split = bf.readLine().split(" ");
            int x1 = Integer.parseInt(split[0]);
            int y1 = Integer.parseInt(split[1]);
            int x2 = Integer.parseInt(split[2]);
            int y2 = Integer.parseInt(split[3]);
            //扫描线模板
            //竖着的 左边和右边
            segments[i++] = new Segment(x1,y1,y2,1);//扫描线的入变
            segments[i++] = new Segment(x2,y1,y2,-1);//扫描线的出边
        }
        //排序
        Arrays.sort(segments);
        build(0,10000,1);
        int res = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (i > 0) res += tree[1].len * (segments[i].x1 - segments[i-1].x1);
            update(segments[i].y1,segments[i].y2-1,segments[i].cnt,1);
        }
        System.out.println(res);
    }

    private static void build(int l, int r, int treeIndex) {
        tree[treeIndex] = new Node(l,r);
        if (l == r) return;
        int mid = ( l + r ) >> 1;
        build(l,mid,treeIndex * 2);
        build(mid+1,r,treeIndex * 2 + 1);
    }


    private static void update(int l, int r, int cnt, int treeIndex) {
        if (tree[treeIndex].l >= l && tree[treeIndex].r <= r) {
            tree[treeIndex].cnt += cnt;
        } else {
            int mid = tree[treeIndex].l + tree[treeIndex].r >> 1;
            if (l <= mid) update( l, r, cnt,treeIndex << 1);
            if (r > mid) update( l, r, cnt,treeIndex << 1 | 1);
        }
        pushUp(treeIndex);
    }

    private static void pushUp(int x) {
        if (tree[x].cnt > 0) tree[x].len = tree[x].r - tree[x].l + 1;
        else if (tree[x].l == tree[x].r) tree[x].len = 0;
        else tree[x].len = tree[x*2].len + tree[x*2+1].len;
    }

    static class Node{
        int l;
        int r;
        int cnt;//区间被覆盖的次数
        int len;//[l,r]的区间内被覆盖的长度

        public Node(int l, int r ) {
            this.l = l;
            this.r = r;
        }
    }

    static class Segment implements Comparable<Segment>{
        int x1;
        int y1;
        int y2;
        int cnt;

        public Segment(int x1, int y1, int y2, int cnt) {
            this.x1 = x1;
            this.y1 = y1;
            this.y2 = y2;
            this.cnt = cnt;
        }

        @Override
        //按x从小到大排序
        public int compareTo(Segment o) {
            return x1 - o.x1;
        }
    }
}