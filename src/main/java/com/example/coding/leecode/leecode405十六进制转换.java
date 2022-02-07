package com.example.coding.leecode;

/**
 * @Author 神様だよ
 * @Date 2022/1/4 21:27
 * @Version 1.0
 * @description:
 */
public class leecode405十六进制转换 {
    public String toHex(int num) {
        if (num == 0) return "0" ;
        StringBuilder sb = new StringBuilder();
        //每次拿十六进制的4位用 连环除 求出十六进制拼起来
        int mask = 0xf ;
        while (num != 0){
            int d = num & mask ;
            sb.append(to(d)) ;
            num >>>= 4 ;
        }
        return sb.reverse().toString();
    }

    String to(int d){
        if (d == 0) return "0" ;
        StringBuilder sb = new StringBuilder();
        while (d != 0) {
            int x = d % 16 ;
            if (x < 10) {
                sb.append(x) ;
            } else {
                sb.append(toChar(x)) ;
            }
            d /= 16 ;
        }
        return sb.toString();
    }

    char toChar (int d){
        return (char)((d - 10) + 'a');
    }
}
