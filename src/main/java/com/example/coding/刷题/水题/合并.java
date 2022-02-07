package com.example.coding.刷题.水题;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 14:59
 * @Version 1.0
 * @description:
 */
public class 合并 {
    public static void main(String[] args) {
        PriorityQueue<Integer> Set=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[m];
        for(int i=0;i<n;i++){
            Set.add(sc.nextInt());
        }
        for(int i=0;i<m;i++){
            Set.add(sc.nextInt());
        }
        for(int i=0;i<n+m;i++){
            System.out.println(Set.poll());
        }

    }
}
