package com.example.coding.leecode.数论.位运算;

/**
 * @Author 神様だよ
 * @Date 2022/1/1 20:43
 * @Version 1.0
 * @description:
 */
public class 两个整数的和不能用加法 {
    /**
     * 思路：加法 就是 不进位的加法（异或运算） 的基础上 加上进位的结果 进位可以用（a&b>>1）求
     */
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }
}
