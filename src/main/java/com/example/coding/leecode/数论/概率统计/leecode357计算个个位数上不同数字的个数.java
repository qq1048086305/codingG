package com.example.coding.leecode.数论.概率统计;

/**
 * @Author 神様だよ
 * @Date 2022/1/1 19:06
 * @Version 1.0
 * @description:
 */
public class leecode357计算个个位数上不同数字的个数 {
    public  static int countNumbersWithUniqueDigits(int n) {
        n = Math.min(n, 10); // 大于 10 位一定重复不需要考虑
        if (n == 0) return 1;
        //每一位可以选0-9   最高位不能选0有9种选择方式 次位能选0也是9种
        // 从最高位开始考虑 根据乘法原理可以得到答案

        int res=0,base=9;//base是第一位
        for(int i=1;i<n;i++){
            res+=base;
            base*=10-i;
        }
        res+=base;
        res+=1;//0是一种特殊情况
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }
}
