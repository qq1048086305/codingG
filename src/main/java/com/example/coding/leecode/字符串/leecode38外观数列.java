package com.example.coding.leecode.字符串;

/**
 * @Author 神様だよ
 * @Date 2021/12/4 8:22
 * @Version 1.0
 * @description:
 */
public class leecode38外观数列 {
    //https://www.acwing.com/solution/content/15176/
    //双指针根据当前的扩展即可
    //https://leetcode.com/problems/count-and-say/description/
    /**
     * 一开始是"1"的状态，操作n - 1次，每一次在当前字符串的基础下进行2操作
     * 2、给定一个字符串，枚举每个字符j，k从j开始，找到字符j的连续区间[j,k - 1]，将个数和字符j拼接到t字符串后面，j继续从k位置开始枚举
     * 3、每次操作更新ans = t
     * @param args
     */
    public static void main(String[] args) {
        int n=20;
        StringBuilder ans = new StringBuilder("1");
        //处理n-1次
        for(int i = 1;i < n;i ++)
        {
            StringBuilder t = new StringBuilder("");
            for(int j = 0;j < ans.length();j ++)
            {
                int k = j;
                while(k < ans.length() && ans.charAt(k) == ans.charAt(j)) k ++;

                t.append(k - j).append(ans.charAt(j));
                j = k - 1;
            }
            ans = t;
        }
        System.out.println(ans);

    }
}
