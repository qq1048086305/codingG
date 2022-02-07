/*
package com.example.coding;

import java.util.Arrays;
import java.util.Scanner;

*/
/**
 * @Author 神様だよ
 * @Date 2021/11/7 20:22
 * @Version 1.0
 * @description:
 *//*

public class 线段树 {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        Segment_Tree st = new Segment_Tree(n);

        for(int i = 0; i < q; i++){
            int com = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(com == 0)
                st.update(x, y);
            else
                System.out.println(st._find(x, y));
        }
    }
}


// セグメントツリー、再帰を使って処理していく
class Segment_Tree{
    int[] tree;
    int n;


    Segment_Tree(int n){
        for(this.n = 1; this.n < n;)
            this.n *= 2;
        tree = new int[2 * this.n];
        for(int i = 0; i < 2 * this.n; i++)
            tree[i] = Integer.MAX_VALUE;
    }


    void update(int pos, int x){
        // 葉のノード番号
        pos += n;
        tree[pos] = x;

        // 親を辿りながら最小値を更新していく
        while(pos > 1){
            pos /=  2;
            tree[pos] = Math.min(tree[pos * 2], tree[pos * 2 + 1]);
        }
    }


    // yを微調整、ルートとなるノード番号、l,rに両端を設定
    int _find(int x, int y){
        return this.find(x, y + 1, 1, 0, n);
    }


    // 区間a,b、l,rがノードkに対応する区間
    int find(int a, int b, int k, int l, int r){
        int l_min, r_min;

        // a,bが突き抜けてる
        if(r <= a || b <= l)
            return Integer.MAX_VALUE;

        // 完全に含む
        if(a <= l && r <= b)
            return tree[k];
        else{
            l_min = find(a, b, k * 2, l, (l + r) / 2);
            r_min = find(a, b, k * 2 + 1, (l + r) / 2, r);
            return Math.min(l_min, r_min);
        }

    }


}
class SegmentTree{
    int[] tree;
    int N;
    int INF = Integer.MAX_VALUE;
    public SegmentTree(int n){
        int now = 1;
        while(now < n){
            now *= 2;
        }
        this.N = now;
        this.tree = new int[N*2];
        Arrays.fill(tree,2147483647);
    }

    public void update(int i, int x) {
        i += N - 1;
        tree[i] = x;
        while (i > 0) {
            i = (i - 1) / 2;
            tree[i] = Math.min(tree[i * 2 + 1], tree[i * 2 + 2]);
        }
    }

    public int query(int a, int b) {
        return query(a, b+1, 0, 0, N);
    }

    public int query(int a, int b, int k, int l, int r) {
        if (r <= a || b <= l){
            return INF;
        }else if (a <= l && r <= b) {
            return tree[k];
        } else {
            int lv = query(a, b, 2*k+1, l, (l+r)/2);
            int rb = query(a, b, 2*k+2, (l+r)/2, r);
            return merge(lv, rb);
        }
    }

    private int merge(int l, int r) {
        return Math.min(l, r);
    }

    public void printArr(){
        for(int v : tree){
            System.out.print(v + " ");
        }
        System.out.println();
        return;
    }
}
*/
