package com.example.coding.leecode.搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 神様だよ
 * @Date 2022/1/23 9:51
 * @Version 1.0
 * @description:
 */
public class LeeCode542的01矩阵 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return matrix;
        int n = matrix.length, m = matrix[0].length;    // n表示行数；m表示列数
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    //从这些点出发找到最近的答案
                    q.offer(new Pair(i, j));
                } else {
                    //找这些点的距离
                    dist[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair t = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                //不越界并且需要找距离的点加入进来
                if (x >= 0 && x < n && y >= 0 && y < m && dist[x][y] == -1) {
                    dist[x][y] = dist[t.x][t.y] + 1;
                    q.offer(new Pair(x, y));
                }
            }
        }

        return dist;
    }

    private int[][] dist;
    private Queue<Pair> q = new LinkedList<>();
    private int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    private class Pair {
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private int x, y;
    }
}
