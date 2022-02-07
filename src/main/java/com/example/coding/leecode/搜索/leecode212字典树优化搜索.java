package com.example.coding.leecode.搜索;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/12/21 13:39
 * @Version 1.0
 * @description:
 */
public class leecode212字典树优化搜索 {
    static Node root;
    static int n,m;
    static List<String> ans = new ArrayList<String>();
    static HashSet<String> set = new HashSet<String>();
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static void insert(String word)
    {
        Node p = root;
        for(int i = 0;i < word.length();i ++)
        {
            int u = word.charAt(i) - 'a';
            if(p.son[u] == null) p.son[u] = new Node();
            p = p.son[u];
        }
        p.is_end = true;
    }
    static void dfs(int x,int y, char[][] board, Node p, String pre)
    {
        if(p.is_end)
        {
            set.add(pre);
        }
        for(int i = 0;i < 4;i ++)
        {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a < 0 || a >= n || b < 0 || b >= m) continue;
            if(board[a][b] == '.') continue;
            int u = board[a][b] - 'a';
            if(p.son[u] != null)
            {
                char t = board[a][b];
                board[a][b] = '.';
                dfs(a, b, board, p.son[u], pre + t);
                board[a][b] = t;
            }
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        ans.clear();
        set.clear();
        n = board.length;
        m = board[0].length;
        int k = words.length;
        for(int i = 0;i < k;i ++) insert(words[i]);

        for(int i = 0;i < n;i ++)
            for(int j = 0;j < m;j ++)
            {
                int u = board[i][j] - 'a';
                if(root.son[u] != null)
                {
                    char t = board[i][j];
                    board[i][j] = '.';
                    dfs(i, j, board, root.son[u], "" + t);
                    board[i][j] = t;
                }
            }

        for(String s : set) ans.add(s);

        return ans;
    }
    static class Node
    {
        boolean is_end;
        Node[] son = new Node[26];
        Node()
        {
            for(int i = 0;i < 26;i ++)
                son[i] = null;
            is_end = false;
        }
}
}
