package com.example.coding.leecode.数论;

/**
 * @Author 神様だよ
 * @Date 2022/1/11 12:40
 * @Version 1.0
 * @description:
 */
public class LeetCode458可怜的小朱 {
    //没只猪都有k+1种状态
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0,k= minutesToTest/minutesToDie;
        while(Math.pow(k+1,pigs) < buckets) pigs++;
        return pigs;
    }
}
