package com.example.coding.acwing蓝桥杯.双指针bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 神様だよ
 * @Date 2021/12/20 14:11
 * @Version 1.0
 * @description:
 */
public class acwing1101bfs走迷宫 {
    static int N = 210;
    //标技数组
    static int[][] dist = new int[N][N];//记录最短距离
    //记录迷宫
    static char[][] g = new char[N][N];
    static int[] dx = new int[] {-1,0,1,0};
    static int[] dy = new int[] {0,1,0,-1};
    static int n;
    static int m;
    static PIIs start;
    static PIIs end;
    static int bfs(PIIs start,PIIs end)
    {
        Queue<PIIs> queue = new LinkedList<PIIs>();
        for(int i = 0;i < n;i++) Arrays.fill(dist[i], -1);
        dist[start.x][start.y] = 0;
        queue.add(start);
        while(!queue.isEmpty())
        {
            PIIs t = queue.poll();
            for(int i = 0;i < 4;i++)
            {
                int x = t.x + dx[i];
                int y = t.y + dy[i];
                if(x < 0 || x >= n || y < 0 || y >= m) continue;
                if(g[x][y] == '#') continue;
                //已经走过了
                if(dist[x][y] != -1) continue;
                dist[x][y] = dist[t.x][t.y] + 1;
                if(x == end.x && y == end.y) return dist[x][y];

                queue.add(new PIIs(x,y));
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());
        while (T-- > 0) {
            String[] s1 = reader.readLine().split(" ");
            n = Integer.parseInt(s1[0]);
            m = Integer.parseInt(s1[1]);

            for(int i = 0;i < n;i++)
            {
                char[] charArray = reader.readLine().toCharArray();
                for(int j = 0;j < m;j++)
                {
                    g[i][j] = charArray[j];
                    if(g[i][j] == 'S') start = new PIIs(i,j);
                    else if(g[i][j] == 'E') end = new PIIs(i,j);
                }
            }

            int t = bfs(start,end);
            if(t == -1) System.out.println("oop!");
            else System.out.println(t);
        }
    }
    static class PIIs{
        public int x;
        public int y;
        public PIIs(int x,int y)
        {
            this.x = x;
            this.y = y;
        }
}
}
