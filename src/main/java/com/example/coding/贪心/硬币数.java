package com.example.coding.贪心;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/6 15:39
 * @Version 1.0
 * @description:
 */
public class 硬币数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = {25,10,5,1};//从大往小贪心的试
        int count = 0;
        for(int i = 0; i < 4;i++){
            count += num / array[i];
            num %= array[i];//剩下的交给下一个实
        }
        System.out.println(count);
    }
}
