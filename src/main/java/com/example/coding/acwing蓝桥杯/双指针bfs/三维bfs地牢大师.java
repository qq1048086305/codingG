package com.example.coding.acwing蓝桥杯.双指针bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/20 14:32
 * @Version 1.0
 * @description:
 */
public class 三维bfs地牢大师 {
    static int N = 110;
    static int L;
    static int R;
    static int C;
    static PIIs start;
    static PIIs end;
    static char[][][] g = new char[N][N][N];
    static int[][][] dist = new int[N][N][N];
    static int[] dx = new int[] {1,-1,0,0,0,0};
    static int[] dy = new int[] {0,0,1,-1,0,0};
    static int[] dz = new int[] {0,0,0,0,1,-1};
    static int bfs()
    {
        Queue<PIIs> q = new LinkedList<PIIs>();
        q.add(start);

        for(int i = 0;i < L;i++)
            for(int j = 0;j < R;j++)
                Arrays.fill(dist[i][j], -1);

        dist[start.x][start.y][start.z] = 0;

        while(!q.isEmpty())
        {
            PIIs t = q.poll();

            for(int i = 0;i < 6;i++)
            {
                int a = t.x + dx[i];
                int b = t.y + dy[i];
                int c = t.z + dz[i];
                if(a < 0 || a >= L || b < 0 || b >= R || c < 0 || c >= C) continue;
                if(g[a][b][c] == '#') continue;
                if(dist[a][b][c] != -1) continue;

                dist[a][b][c] = dist[t.x][t.y][t.z] + 1;
                if(a == end.x && b == end.y && c == end.z) return dist[a][b][c];
                q.add(new PIIs(a,b,c));
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        {
            L = scan.nextInt();
            R = scan.nextInt();
            C = scan.nextInt();
            if(L == 0 && R == 0 && C == 0) break;
            for(int i = 0;i < L;i ++)//第i层
            {
                for(int j = 0;j < R;j ++)//第i层第j行
                {
                    char[] charArray = scan.next().toCharArray();
                    for(int k = 0;k < C;k ++)//第i层第k列
                    {
                        g[i][j][k] = charArray[k];
                        if(g[i][j][k] == 'S') start = new PIIs(i,j,k);
                        if(g[i][j][k] == 'E') end = new PIIs(i,j,k);
                    }
                }
            }
            int distance = bfs();
            if(distance == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + distance + " minute(s).");
        }
    }
    static class PIIs
    {
        public int x;//第x层
        public int y;//第y行
        public int z;//第z列
        public PIIs(int x,int y,int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }
   }
}
