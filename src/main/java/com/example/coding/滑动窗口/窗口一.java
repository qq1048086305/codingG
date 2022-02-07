package com.example.coding.滑动窗口;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/8 22:24
 * @Version 1.0
 * @description:
 */
public class 窗口一 {
    /**
     *  给一个长度为N的数列  和一个整数S
     * が与えられます。要素の総和が S
     *  从连续的一段序列找到最小的长度
     *  以上となる連続する部分列のうち、最も短いものの長さ（smallest window length）を求めてください。ただし、そのような部分列が存在しない場合は 0 と報告してください。
     * @param args
     */
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            long S = sc.nextLong();
            long[] A = new long[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextLong();
            }
            int i = 0, j = 0, ans = 100000000;
            //sum存储了一个窗口前缀和 每次去掉一个树后还保留了删掉一个后的前缀和的
            long sum = 0;
            while (i < N) {
                while (j < N && sum < S) {
                    sum += A[j];
                    j++;
                }
                if (sum >= S) {
                    ans = Math.min(j - i, ans);
                }
                //从当前窗口从前往后去掉元素
                sum -= A[i];
                i++;
            }
            if (ans == 100000000) {
                ans = 0;
            }
            System.out.println(ans);
        }
    }
}
