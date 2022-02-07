package com.example.coding.AOJ刷题;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/29 19:31
 * @Version 1.0
 * @description:
 */
public class SelectingSubjects {
    static PriorityQueue<Integer> heap1=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    static PriorityQueue<Integer> heap2=new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a,b,c,d,e,f;
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        d=sc.nextInt();
        e=sc.nextInt();
        f=sc.nextInt();
        heap1.add(a);
        heap1.add(b);
        heap1.add(c);
        heap1.add(d);
        heap2.add(e);
        heap2.add(f);
        int sum=0;
        sum+=heap1.poll();
        sum+=heap1.poll();
        sum+=heap1.poll();
        sum+=heap2.poll();
        System.out.println(sum);
    }

}
