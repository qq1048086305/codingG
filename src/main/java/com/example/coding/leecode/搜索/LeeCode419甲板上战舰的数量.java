package com.example.coding.leecode.搜索;

/**
 * @Author 神様だよ
 * @Date 2022/1/10 17:29
 * @Version 1.0
 * @description:
 */
public class LeeCode419甲板上战舰的数量 {
    boolean[][] visited;
    int[] dx = {1, 0}, dy = {0, 1};
    int n, m;
    //求连通块数量
    public int countBattleships(char[][] board) {
        int res = 0;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    dfs(board, i, j);
                    res++;
                }
            }
        return res;
    }

    private void dfs(char[][] board, int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 2; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x < m && y < n && !visited[x][y] && board[x][y] == 'X') {
                dfs(board, x, y);
            }
        }
    }
}
