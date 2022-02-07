package com.example.coding.队列;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/13 17:07
 * @Version 1.0
 * @description:
 */
public class 字典删除 {
    public static void main(String[] args) {
        int m, n, t, ans = 0;
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();
        n=sc.nextInt();
        ArrayList<Integer> v=new ArrayList<>();

        for(int i=0;i<n;i++) {
            t=sc.nextInt();
            if (!v.contains(t)) { // 如果不在内存中
                v.add(t); // 加入内存
                ++ans;
            }
            if (v.size() > m) // 内存满了
               v.remove(0);
        }
        System.out.println(ans);
    }

}
