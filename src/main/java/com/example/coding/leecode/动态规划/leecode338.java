package com.example.coding.leecode.动态规划;

/**
 * @Author 神様だよ
 * @Date 2021/12/10 14:41
 * @Version 1.0
 * @description:
 */
public class leecode338 {
    //https://leetcode.com/problems/counting-bits/description/
    /**
     * 令f[i]表示 i 的二进制表示中1的个数。
     * 则f[i]可以由f[i/2]转移过来，ii 的二进制表示和 ⌊i/2⌋的二进制表示除了最后一位都一样，所以f[i] = f[i/2] + (i&1);
     *
     * 时间复杂度分析：总共有 n个状态，每个状态进行转移的计算量是 O(1)所以总时间复杂度是 O(n)。
     */
}
