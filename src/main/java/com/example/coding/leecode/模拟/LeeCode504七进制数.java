package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 12:14
 * @Version 1.0
 * @description:
 */
public class LeeCode504七进制数 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean f = false;
        if (num < 0) {
            f = true;
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (f) sb.append('-');
        return sb.reverse().toString();
    }
}
