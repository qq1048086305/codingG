package com.example.coding.leecode.数据结构.字典树;

/**
 * @Author 神様だよ
 * @Date 2022/1/9 9:44
 * @Version 1.0
 * @description:
 */
public class leetCode421数组异或和最大 {
    class Node {
        Node[] ns = new Node[2];
    }
    Node root = new Node();
    void add(int x) {
        Node p = root;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (p.ns[u] == null) p.ns[u] = new Node();
            p = p.ns[u];
        }
    }
    int getVal(int x) {
        int ans = 0;
        Node p = root;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1, b = 1 - a;
            if (p.ns[b] != null) {
                ans |= (b << i);
                p = p.ns[b];
            } else {
                ans |= (a << i);
                p = p.ns[a];
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            add(i);
            int j = getVal(i);
            ans = Math.max(ans, i ^ j);
        }
        return ans;
    }
}
