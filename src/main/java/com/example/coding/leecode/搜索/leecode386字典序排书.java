package com.example.coding.leecode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 18:23
 * @Version 1.0
 * @description:
 */
public class leecode386字典序排书 {
    List<Integer> res;
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return res;
    }
    public void dfs(int u, int n) {
        if (u <= n) {
            res.add(u);
        } else {
            return;
        }
        for (int i = 0; i <= 9; i++) {
            dfs(u * 10 + i, n);
        }
    }
}
