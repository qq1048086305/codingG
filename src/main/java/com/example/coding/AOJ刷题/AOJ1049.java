package com.example.coding.AOJ刷题;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/6 12:26
 * @Version 1.0
 * @description:
 */
public class AOJ1049 {
    //解法 用二进制存储当前选择的状态 bit 0001->0011->0111->1111依次往上加
    //预处理两个点之间的最大距离是多少 每次都从第一个1开始判断如果把当前的0变成一的最大距离是多少 记录在pos[]数组里
    //pos[i]代表从0到i区间上完成的最大距离是多少
    //比如把左边第一个0变成1 判断如果直接从最右边的1 pos[0]+pos[0][4]的距离和当前pos[4]比较取最大的
    int n, ans;
    int[] pos;
    int[][] d;
    int INF = 1 << 30;
    public static void main(String[] args) throws IOException {

        new AOJ1049().run();
    }

    private void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n == 0)
                break;
            d = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    d[i][j] = scanner.nextInt();
            for (int i = 0; i < n; i++)//将地图里保存的数据替换成彼此之间可达的情况最大距离
                for (int j = 0; j < n; j++) {
                    d[i][j] = Math.max(d[i][j], d[j][i]);
                }
            //记录答案
            ans = INF;
            //pos记录当前状态
            pos = new int[n];
            //bit代表当前二进制状态
            dfs(0, 0);
            System.out.println(ans);
        }
    }

    private void dfs(int right, int bit) {
        //right如果大于ans代表没有更小的答案了 return 剪枝
        if (ans <= right)
            return;
        //统计二进制中1的个数 满足要求更新答案
        if (Integer.bitCount(bit) == n) {
            ans = right;
            return;
        }
        for (int i = 0; i < n; i++) {
            //已经找过当前这个家的状态了
            if (((bit >> i) & 1) == 1)
                continue;
            //改变bit的状态
            int nbit = bit | 1 << i;
            String count=Integer.toBinaryString(bit);
            String count2=Integer.toBinaryString(nbit);
            //找到bit状态选择的点都是是哪一个 更新从该状态到到当前点的距离
            for (int j = 0; j < n; j++) {
                if (((bit >> j) & 1) == 0)
                    continue;
                //更新上个状态到i点最大距离
                pos[i] = Math.max(pos[i], pos[j] + d[j][i]);
            }
            dfs(pos[i], nbit);
            //状态回溯
            pos[i] = 0;
        }
    }
}
