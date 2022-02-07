package com.example.coding.leecode.搜索;

/**
 * @Author 神様だよ
 * @Date 2021/12/20 9:11
 * @Version 1.0
 * @description:
 */
public class leecode79单词搜索 {
    /**
     *https://leetcode-cn.com/problems/word-search/
     */
    static int n,m;
    static int[] dx = new int[]{0,-1,0,1};
    static int[] dy = new int[]{-1,0,1,0};
    static boolean dfs(char[][]board,String word,int depth,int x,int y)
    {
        if(board[x][y] != word.charAt(depth)) return false;
        //若到达了最后的位置
        if(depth == word.length() - 1) return true;

        char c = board[x][y];
        //标记
        board[x][y] = '*';

        for(int i = 0;i < 4;i ++)
        {
            int u = x + dx[i];
            int v = y + dy[i];
            if(u < 0 || u >= n || v < 0 || v >= m) continue;
            if(board[u][v] == '*') continue;
            if(dfs(board,word,depth + 1,u,v)) return true;
        }
        //回溯
        board[x][y] = c;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for(int i = 0;i < n;i ++)
            for(int j = 0;j < m;j ++)
                if(board[i][j] == word.charAt(0))
                    if(dfs(board,word,0,i,j))
                        return true;
        return false;
    }
}
