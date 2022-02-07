package com.example.coding.acwing蓝桥杯;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/10 15:52
 * @Version 1.0
 * @description:
 */
public class 费解的开关 {
    //目标是把所有开关全部变成1，由于当上一行的状态确定时，若上一行存在0的状态，只能由下一行的位置去影响上一行的0，因此可以使用递推
    static int N = 6;
    static int[][] bg = new int[N][N];
    static int[][] g = new int[N][N];
    static int[] dx = new int[] {0,-1,0,1,0};
    static int[] dy = new int[] {-1,0,1,0,0};
    static void trun(int x,int y)
    {
        for(int i = 0;i < 5;i ++)
        {
            int a = x + dx[i];
            int b = y + dy[i];
            if(a < 0 || a >= 5 || b < 0 || b >= 5) continue;
            g[a][b] ^= 1;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n -- > 0)
        {
            int res = 10;

            for(int i = 0;i < 5;i ++)
            {
                String s = scan.next();
                for(int j = 0;j < 5;j ++)
                    bg[i][j] = s.charAt(j) - '0';
            }
            //枚举第一行开关所有情况
            for(int op = 0;op < 1 << 5;op ++)
            {
                int cnt = 0;
                //取出备份
                for(int u = 0;u < 5;u ++)
                    for(int v = 0;v < 5;v ++)
                        g[u][v] = bg[u][v];

                //操作第0行开关
                for(int i = 0;i < 5;i ++)
                    if((op >> i & 1) == 1)
                    {
                        trun(0,i);
                        cnt ++;
                    }
                //递推出第1到4行的状态 如果当前灯灭着只能按下一行开关把它怼亮
                for(int i = 0;i < 4;i ++)
                    for(int j = 0;j < 5;j ++)
                        if(g[i][j] == 0)
                        {
                            trun(i + 1,j);
                            cnt ++;
                        }

                //检查最后一行的灯是否全亮
                boolean success = true;
                for(int i = 0;i < 5;i ++)
                    if(g[4][i] == 0)
                        success = false;
                if(success && res > cnt) res = cnt;
            }

            if(res > 6) res = -1;
            System.out.println(res);
        }

    }
}
