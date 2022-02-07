package com.example.coding.acwing蓝桥杯.双指针bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 神様だよ
 * @Date 2021/12/20 14:30
 * @Version 1.0
 * @description:
 */
public class acwing1240完全二叉树层最大权值和 {
    static int N = 100010;
    static int[] a = new int[N];
    static int n;
    static int bfs()
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        long maxv = Integer.MIN_VALUE;
        int level = 0;//答案的深度
        int levelNo = 0;//当前的深度
        while(!q.isEmpty())
        {
            levelNo ++;
            long res = 0;
            int len = q.size();
            for(int i = 0;i < len;i++)
            {
                int t = q.poll();
                res += a[t];
                if((t << 1 )<= n) q.add(t << 1);//2n
                if((t << 1 | 1 )<= n) q.add(t << 1 | 1);//2n+1
            }
            if(res > maxv)
            {
                maxv = res;
                level = levelNo;
            }
        }
        return level;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine().trim());
        String[] s1 = reader.readLine().split(" ");
        for(int i = 1;i <= n;i++)
        {
            a[i] = Integer.parseInt(s1[i - 1]);
        }
        System.out.println(bfs());
    }
}
