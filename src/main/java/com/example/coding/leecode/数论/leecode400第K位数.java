package com.example.coding.leecode.数论;

/**
 * @Author 神様だよ
 * @Date 2022/1/4 20:47
 * @Version 1.0
 * @description:
 */
public class leecode400第K位数 {
    public int findNthDigit(int n) {
        //1234567891011121314151617181920
        //1 - [1,9]             9
        //2 - [10,99]          90
        //3 - [100,999]       900
        //4 - [1000,9999]    9000
        //digit表示 每一段是多少位
        //start表示 乘以多少个10，每段的位的基数
        //count表示 每一段都有多少个数
        long digit = 1,start = 1,count = 9;
        while(n > count){
            n -=count;
            start*=10;  // 1,10,100
            digit+=1;   // 1,2,3
            count = 9*start*digit;  //每段占了多少位
        }//此步计算出来之后，就可以算出它在那个位数的区间段中
        //n-1/k是向上取整
        long nums = start + (n-1)/digit; //  假设 n=13-->n=3  start=10->10+2/2==11
        //                             确定已经要找的这个数是11中
        // 确定是11的中某个位数,取余即为答案
        int res = String.valueOf(nums).charAt(((int)n-1)%(int)digit)-'0';
        return res;
    }
}
