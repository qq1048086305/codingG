package com.example.coding.leecode.数论;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 9:36
 * @Version 1.0
 * @description:
 */
public class leecode258数字相加 {
    /**
     * https://www.acwing.com/solution/content/20074/
     */
    public int addDigits(int num) {
        if(num == 0) return 0;
        if(num % 9 != 0) return num % 9;
        return 9;
    }
}
