package com.example.coding.acwing蓝桥杯.双指针bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/20 14:42
 * @Version 1.0
 * @description:
 */
public class acwing1233全球变暖 {
    /**
     * 遍历所有未遍历过的陆地，
     * 通过bfs计算出当前位置连通陆地的数量total，
     * 以及被淹没陆地的数量bound,若total == bound表示完整淹没的一个岛屿
     */
    static int N = 1010;
    static int n;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[] dx = new int[] {-1,0,1,0};
    static int[] dy = new int[] {0,1,0,-1};
    static boolean bfs(int x,int y)
    {
        Queue<PIIs> q = new LinkedList<PIIs>();
        q.add(new PIIs(x,y));
        st[x][y] = true;
        int total = 0;//当前位置连通陆地的数量
        int bound = 0;//被淹没陆地的数量
        while(!q.isEmpty())
        {
            PIIs t = q.poll();
            total ++;
            boolean is_bound = false;//判断岛屿是否被淹没
            for(int i = 0;i < 4;i++)
            {
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                if(a < 0 || a >= n || b < 0 || b >= n) continue;
                if(st[a][b]) continue;
                if(g[a][b] == '.')
                {
                    is_bound = true;
                    continue;
                }
                q.add(new PIIs(a,b));
                st[a][b] = true;
            }
            if(is_bound) bound ++;
        }
        //niubi
        return total == bound;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for(int i = 0;i < n;i++)
        {
            char[] charArray = scan.next().toCharArray();
            for(int j = 0;j < n;j++)
            {
                g[i][j] = charArray[j];
            }
        }
        int cnt = 0;
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++)
            {
                if(!st[i][j] && g[i][j] == '#')
                {
                    if(bfs(i,j)) cnt ++;
                }
            }
        }
        System.out.println(cnt);
    }
    static class PIIs
    {
        public int x;
        public int y;
        public PIIs(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
}
}
