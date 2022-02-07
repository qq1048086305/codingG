package com.example.coding.leecode.搜索;

import java.util.*;

/**
 * @Author 神様だよ
 * @Date 2022/1/1 20:27
 * @Version 1.0
 * @description:
 */
public class leecode365水壶问题 {
    int x, y;
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        this.x = x;
        this.y = y;

        Queue<Pair> q = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        Pair start = new Pair(0, 0);
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.a == z || cur.b == z || cur.a + cur.b == z) return true;
            for (Pair next : getNextList(cur.a, cur.b)) {
                if (!visited.contains(next)) {
                    q.add(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }

    // 重点是状态怎么转换的
    private List<Pair> getNextList(int a, int b) {
        List<Pair> ans = new ArrayList<>();
        // a倒满
        ans.add(new Pair(x, b));
        // b倒满
        ans.add(new Pair(a, y));
        // a清空
        ans.add(new Pair(0, b));
        // b清空
        ans.add(new Pair(a, 0));
        // 用a倒满b
        int t = Math.min(a, y - b);
        ans.add(new Pair(a - t, b + t));
        // 用b倒满a
        t = Math.min(b, x - a);
        ans.add(new Pair(a + t, b - t));
        return ans;
    }

    static class Pair {
        int a, b;

        Pair(int x, int y) {
            a = x;
            b = y;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
