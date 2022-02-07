package com.example.coding.数论.位运算;

import com.example.coding.Main;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/16 12:58
 * @Version 1.0
 * @description:
 */
public class 高低位交换 {
    /**
     * 对于这道题目，我们只需要将原数的后16位前移至新数的前16位，将原数的前16位前移至新数的后16位，这道题目就做完了。
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long x=sc.nextLong();
        //然后&0x0000ffff就相当于把前面16位清空（因为都是0嘛），&0xffff0000相当于把后面16位清空（同理嘛）
        System.out.println(( (x&0x0000ffff)<<16)|((x&0xffff0000)>>16));
    }
}
