package com.example.coding.队列;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/13 16:19
 * @Version 1.0
 * @description:
 */
public class 约瑟夫环 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            q.add(i);
        }
        LinkedList<Integer> list=new LinkedList<>();
        int count=1;//m的时候出队
        while (!q.isEmpty()){
            int cur=q.poll();
            if(count==m){
                System.out.print(cur+" ");
                count=1;
            }else{
                q.add(cur);
                count++;
            }
        }
    }
}
