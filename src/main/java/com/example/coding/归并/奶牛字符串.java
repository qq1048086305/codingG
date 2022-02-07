package com.example.coding.归并;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @Author 神様だよ
 * @Date 2021/11/12 12:28
 * @Version 1.0
 * @description:
 */
public class 奶牛字符串 {
    //二倍二倍变过来的我们就二倍二倍的分治回去
    public static void main(String[] args) throws IOException {
        long  l=0, n=0, t=0;
        char s[]=new char[55];
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s1[] = sc.readLine().split("\\s+");
        String ss=s1[0];
        for(int i=0;i<ss.length();i++){
            s[i+1]=ss.charAt(i);
        }
        t=l=ss.length();
        //这里N是long型的我们不能模拟出一个字符串来处理 所以我们采用分治方法把问题分小找出答案 类似二分？
        n=Long.parseLong(s1[1]);
        //第n个位置也是由最初始字符转移来的倒着退回去就行了
        while (t < n) t <<= 1;
        //一直找到t和l相等的时候
        while (t != l) {
            t >>= 1;
            //在前半段就直接缩小范围
            if (n <= t) continue;
            //如果当前位置是后半段的第一个字符 那就是由前半段最后一个来的
            if (t + 1 == n) n = t;
            //其他情况就按照正常的二倍复制关系来处理
            else n -= 1 + t;
        }
        //通过题意可得，当第 N 个字符在长度为 t 的字符串的后半段时
        // ，前半段字符串中的第 N-1-t/2  个字符肯定与第 N 个字符相同，
        // 因为第 N 个字符在前一次操作时就是有第 N-1-t/2 个字符转换过来的，
        // 所以我们可以由此写出以下代码
        System.out.println(s[Integer.parseInt(n+"")]);
    }
}
