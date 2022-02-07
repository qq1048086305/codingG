package com.example.coding.数论.扩展欧几里得原理;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 13:36
 * @Version 1.0
 * @description:
 */
public class 同余方程 {
    static long x, y;//目前方程真正的解
    //求最小正整数解
    static void exgcd(long a, long b)
    {
        //当前目的：求解 ax + by = gcd(a, b) 这么一个方程

        if(b == 0) //a, b不断改变的过程中，b最终必然会成为0
        {
            //在 b = 0 时方程还要成立？ 使 x = 1, y = 0 ，必然成立
            x = 1;
            y = 0; //建议返回0。不过y = 7能AC，证明了最后一个等式不受最后一个y影响
            return;
        }

        exgcd(b, a % b);//把下一层系数传进去（先求下一个方程的解 ）

        //现在我们已经拿到了下一个方程的解x, y
        long tx = x;//暂时存一下x，别丢了
        x = y;
        y = tx - a / b * y;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter cout=new PrintWriter(System.out);
        long a,b;
        a=sc.nextLong();
        b=sc.nextLong();
        exgcd(a,b);
        x=(x%b+b)%b;
        cout.printf("%d\n",x);
        cout.close();
    }

}
