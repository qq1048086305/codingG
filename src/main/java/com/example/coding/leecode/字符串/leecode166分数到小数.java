package com.example.coding.leecode.字符串;

/**
 * @Author 神様だよ
 * @Date 2021/12/4 10:16
 * @Version 1.0
 * @description:
 */
public class leecode166分数到小数 {
    //给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
    //
    //如果小数部分为循环小数，则将循环的部分括在括号内。

    /**
     * 需用用long记录，当分子取-2^31，分母取-1，得出来的结果是2^31会爆int
     * 2、若x % y == 0，则直接返回x / y，若x和y其中一个是负数，则加个负号
     * 3、假设x，y都是整数，且不满足x % y == 0，则目标是找到第一个重复的余数
     * (1)先将整数部分加入到res中
     * (2)用哈希表记录每个余数的对应的位置
     * (3)若当前余数是x，则记录当前余数的位置，则x * 10 / y就是下一个小数，将该小数加入到res中，x * 10 % y就是下一个余数，若哈希中已经存在该余数，则将当前余数的位置往后的小数用括号括起来，例如12.3214214 = 12.3(214)，找到2对应的位置，将214括起来
     */

    //https://leetcode.com/problems/fraction-to-recurring-decimal/submissions/
}
