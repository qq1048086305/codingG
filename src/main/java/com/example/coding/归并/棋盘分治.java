package com.example.coding.归并;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/12 13:16
 * @Version 1.0
 * @description:
 */
public class 棋盘分治 {
    static int n,st,sp;
    static char c[]=new char[200];
    static void print()                                  //打印
    {
        int i;
        //System.out.print("step "+st+":");
        for (i=1;i<=2*n+2;i++) System.out.print(c[i]);
        System.out.println();
        st++;//记录第几行
    }
    static void init(int n)                             //初始化
    {
        int i;
        st=0;
        sp=2*n+1;
        //从1开始
        for (i=1;i<=n;i++) c[i]='o';
        for (i=n+1;i<=2*n;i++) c[i]='*';
        c[2*n+1]='-';c[2*n+2]='-';//空位置放'-'
        print();
    }
    static void move(int k)     //移动从k为起点（中间点）的棋盘
    {
        int j;
        //sp记录的是当前第一个'-'所在的位置
        //一次处理两个字符对换
        for (j=0;j<=1;j++)
        {
            c[sp+j]=c[k+j];//
            c[k+j]='-';
        }
        sp=k;//被移动到k了
        print();
    }
    static void mv(int n)                                       //主要过程
    {
        int i,k;
        if (n==4)                //n等于4的情况要特殊处理
        {   //4是递归的底子所有的都到这里来处理
            move(4); move(8); move(2); move(7); move(1);
        }
        else
        {   //这么想 当n=5 的时候 我们就在4的基础上多处理一步就变成了4的状态 即挪了n之后去挪2*n-1倒数第四个减号
            move(n); move(2*n-1); mv(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        init(n);
        mv(n);
    }
}
