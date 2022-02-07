package com.example.coding.数据结构;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/**
 * @Author 神様だよ
 * @Date 2021/11/13 15:54
 * @Version 1.0
 * @description:
 */
public class 二维动态链表 {
    public static void main(String[] args)
    {
        int N = (int) (1e5+5);
        Node nodes[]=new Node[N];
        int n,q;
        Scanner scanner = new Scanner(System.in);
        n= scanner.nextInt();
        q= scanner.nextInt();

        while (q>0)
        {

            int x;
            x= scanner.nextInt();
            if (x==1)
            {
                int i,j,k;
                i= scanner.nextInt();
                j= scanner.nextInt();
                k= scanner.nextInt();
                nodes[i]=new Node();
                nodes[i].s= nodes[i].s+1;
                nodes[i].v1.add(j);
                nodes[i].v2.add(k);

            }
            else
            {
                int b,c;
                b= scanner.nextInt();
                c= scanner.nextInt();
                if (nodes[b]==null)
                {
                    nodes[b]=new Node();
                }
                //获取最新一次的更新状况
                for (int i=nodes[b].s-1;i>=0;i--)
                {
                    if (c == nodes[b].v1.get(i))
                    {
                        System.out.println(nodes[b].v2.get(i));//因此时是最新的存放情况，所以有解后需要直接退出查询
                        break;
                    }
                }

            }
            q--;
        }

    }
    static class Node
    {

        public int s=0;
        ArrayList<Integer> v1 =new  ArrayList();
        ArrayList<Integer> v2 =new  ArrayList();
    }
}
