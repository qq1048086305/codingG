package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2021/12/23 8:16
 * @Version 1.0
 * @description:
 */
public class leecode289生命游戏 {
    //https://leetcode-cn.com/problems/game-of-life/
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] ans = new int[m][n];
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,-1},{1,1},{-1,1},{-1,-1}};

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int cnt = 0;
                for (int i = 0; i < dir.length; i++) {
                    int x = row+dir[i][0];
                    int y = col+dir[i][1];
                    if (x<0||y<0||x>=m||y>=n){
                        continue;
                    }
                    cnt += board[x][y];
                }

                if (board[row][col] == 1){
                    //如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                    ans[row][col] = (cnt == 2 || cnt == 3)?1:0;
                    //如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                    //如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                }else{
                    //如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    ans[row][col] = cnt==3?1:0;
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = ans[row][col];
            }
        }
    }
}
