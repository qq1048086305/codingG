package com.example.coding.leecode.数论;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 18:54
 * @Version 1.0
 * @description:
 */
public class leecode390消除游戏 {
    //https://leetcode-cn.com/problems/elimination-game/submissions/
    public int lastRemaining(int n) {
        if (n == 1) return 1;
        return 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}
