package com.example.coding.有序表的使用;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/7 18:02
 * @Version 1.0
 * @description:
 */
public class 查找去重 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int test = in.nextInt();
        HashSet<Long> hs = new HashSet<>();
        for(int i=0; i< test; i++){
            int x = in.nextInt();
            if(x==0){
                long y = in.nextLong();
                hs.add(y);
                out.println(hs.size());
            }else if(x==1){
                long y = in.nextLong();
                if(hs.contains(y))
                    out.println(1);
                else
                    out.println(0);
            }
        }
        out.flush();
    }
}
