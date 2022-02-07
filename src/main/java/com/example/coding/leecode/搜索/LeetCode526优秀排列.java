package com.example.coding.leecode.搜索;

/**
 * @Author 神様だよ
 * @Date 2022/1/22 13:18
 * @Version 1.0
 * @description:
 */
public class LeetCode526优秀排列 {
    boolean [] used ;
    int n ;
    public int countArrangement(int N) {
        int [] a = new int [N + 1];
        this.n = N ;
        for (int i = 1 ; i <= N ; ++i) {
            a[i] = i ;
        }
        used = new boolean[N + 1];
        return dfs(a, 1) ;
    }

    int dfs(int [] a, int idx){
        if (idx == a.length) return 1 ;
        int ret = 0 ;
        for (int i = 1 ;i <= n ; ++i) {
            if (used[i]) continue ;
            if (a[i] % idx != 0 && idx % a[i] != 0) continue ;
            used[i] = true ;
            ret += dfs(a, idx + 1) ;
            used[i] = false ;
        }
        return ret ;
    }
}
