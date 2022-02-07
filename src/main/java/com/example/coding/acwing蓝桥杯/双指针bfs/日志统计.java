package com.example.coding.acwing蓝桥杯.双指针bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/12/20 14:09
 * @Version 1.0
 * @description:
 */
public class 日志统计 {
    static int N = 100010;
    static PIIs[] logs = new PIIs[N];
    static int[] cnt = new int[N];
    static boolean[] st = new boolean[N];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int d = Integer.parseInt(s1[1]);
        int k = Integer.parseInt(s1[2]);
        for(int i = 0;i < n;i++)
        {
            String[] s2 = reader.readLine().split(" ");
            int t = Integer.parseInt(s2[0]);
            int id = Integer.parseInt(s2[1]);
            logs[i] = new PIIs(t,id);
        }
        //按时间从小到大排序
        Arrays.sort(logs,0,n);
        //双指针走一遍 统计满足条件的结果
        for(int i = 0,j = 0;i < n;i++)
        {
            int id = logs[i].id;
            cnt[id] ++;
            while(logs[i].t - logs[j].t >= d)
            {
                cnt[logs[j].id] --;
                j ++;
            }
            if(cnt[id] >= k) st[id] = true;
        }
        for(int i = 0;i <= 100000;i++)
        {
            if(st[i])
                System.out.println(i);
        }

    }
}
class PIIs implements Comparable<PIIs>
{
    public int t;
    public int id;
    public PIIs(int t,int id)
    {
        this.t = t;
        this.id = id;
    }
    @Override
    public int compareTo(PIIs o) {
        // TODO 自动生成的方法存根
        return Integer.compare(t, o.t);
    }
}
