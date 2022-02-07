package com.example.coding.leecode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/10 17:15
 * @Version 1.0
 * @description:
 */
public class LeetCode417太平洋航建 {
    int [][] grid ;
    int [][] matrix;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int n = matrix.length ;
        int m = matrix[0].length ;
        grid = new int [n][m];
        this.matrix = matrix ;
        //从边界走一遍 grid数组里以位运算的形式存储答案 第一位表示太平洋 第二位表示大西洋都是 1代表可以到达
        for (int i = 0;  i < m ; ++i) {
            dfs(0, i, 1) ;
            dfs(n - 1, i, 2) ;
        }
        for (int i = 0 ; i < n ; ++i) {
            dfs(i, 0, 1) ;
            dfs(i,  m - 1, 2) ;
        }
        //遍历gird数组筛选出=3的答案 即为所求答案
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0 ; i < n ; ++i) {
            for (int j = 0; j < m ; ++j) {
                if (grid[i][j] == 3) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    ret.add(cur) ;
                }
            }
        }
        return ret ;
    }

    int [] dx = {-1 ,1, 0 ,0};
    int [] dy = {0, 0, -1, 1};
    void dfs (int x, int y, int mask){
        //标记当前位置值
        grid[x][y] |= 1 << mask - 1 ;
        int n = grid.length;
        int m = grid[0].length ;
        //四个方向找能不能到达太平洋和大西洋
        for (int i = 0; i < dx.length ; ++i) {
            int a = x + dx[i];
            int b = y + dy[i] ;
            //只能从高往低走判断一下
            if (a < 0 || a >= n || b < 0 || b >= m || matrix[a][b] < matrix[x][y]) continue ;
            //当前这一位是否遍历过 遍历过就跳过
            int state = (grid[a][b] >> mask - 1) & 1 ;
            if (state == 1) continue ;
            dfs(a, b, mask) ;
        }
    }
}
