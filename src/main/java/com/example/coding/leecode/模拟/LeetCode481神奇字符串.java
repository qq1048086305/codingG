package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 9:49
 * @Version 1.0
 * @description:
 */
public class LeetCode481神奇字符串 {
    public int magicalString(int n) {
        //初始串
        String s = "122";
        //从长度2开始往后模拟
        int id = 2;
        //k表示当前数字是什么 交替下去 1->2 2->1 从1开始
        int k = 1;
        while (s.length() < n) {//当前数字是什么下面就有几个当前的k
            int cnt = s.charAt(id) - '0';
            for (int i = 0; i < cnt; i++) {
                s += k;
            }
            id++;
            k = 3 - k;
        }
        int res = 0;
        //统计1的个数
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }
}
