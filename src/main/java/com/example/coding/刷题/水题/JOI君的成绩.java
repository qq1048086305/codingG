package com.example.coding.刷题.水题;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 15:06
 * @Version 1.0
 * @description:
 */
public class JOI君的成绩 {
    public static void main(String[] args) {
        PriorityQueue<Integer> Set=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Scanner sc=new Scanner(System.in);
        int a,b,c;
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        Set.add(a);
        Set.add(b);
        Set.add(c);
        System.out.println(Set.poll()+Set.poll());
    }
}
