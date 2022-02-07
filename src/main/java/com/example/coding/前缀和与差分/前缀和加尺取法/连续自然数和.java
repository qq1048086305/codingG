package com.example.coding.前缀和与差分.前缀和加尺取法;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 16:34
 * @Version 1.0
 * @description:
 */
public class 连续自然数和 {
    /**
     * 用i，j代表区间的左右端点
     * 当sum小于目标值M时，将右端点右移（j++），sum会变大
     * 当sum大于目标值M时，将左端点右移（i++），sum会变小
     * 在双指针移动的过程中，如果有sum==M的情况就输出。
     * 因为两个指针都是单调向右移动，也只扫一遍，可以证明时间复杂度为O(n)
     * 左端点大于m/2时即可停止，因为只要长度为2的连续序列和就一定大于m
     */
    static int m;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        m=sc.nextInt();
        int sum=3;
        //i是左端点 j是右端点 最大m/2因为是区间和
        for(int i=1,j=2;i<=m/2;)
        {
            if(sum==m)
            {
                out.printf("%d %d\n",i,j);
                sum-=i;
                i++;
            }
            else if(sum<m)
            {
                j++;
                sum+=j;
            }
            else
            {
                sum-=i;
                i++;
            }
        }
        out.flush();
    }
}
