package com.example.coding.acwing蓝桥杯.双指针bfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/20 14:25
 * @Version 1.0
 * @description:
 */
public class 红与黑搜一个小区域内所有的 {
    static int N = 25;
    static int m;
    static int n;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];//记录该点是否遍历过
    static int[] dx = new int[] {-1,0,1,0};
    static int[] dy = new int[] {0,1,0,-1};
    static int dfs(int x,int y)
    {
        int cnt = 1;
        st[x][y] = true;
        for(int i = 0;i < 4;i++)
        {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a < 0 || a >= n || b < 0 || b >= m) continue;
            if(g[a][b] != '.') continue;
            if(st[a][b]) continue;
            cnt += dfs(a,b);
        }
        return cnt;
    }
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        {
            m = scan.nextInt();
            n = scan.nextInt();
            if(m == 0 && n == 0) break;
            int x = 0;
            int y = 0;
            for(int i = 0;i < n;i ++)
            {
                Arrays.fill(st[i], false);
                char[] charArray = scan.next().toCharArray();
                for(int j = 0;j < m;j ++)
                {
                    g[i][j] = charArray[j];
                    if(g[i][j] == '@')
                    {
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.println(dfs(x,y));
        }

    }
}
