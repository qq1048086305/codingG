package com.example.coding.数论.扩展中国剩余;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Author 神様だよ
 * @Date 2021/11/23 13:52
 * @Version 1.0
 * @description:
 */
public class 扩展中国剩余定理 {
    static int N = (int)1e5 + 10;
    static long x, y, d; static int n;
    static void exgcd(long a, long b)
    {
        //当前目的：求解 ax + by = gcd(a, b) 这么一个方程

        if(b == 0) //a, b不断改变的过程中，b最终必然会成为0
        {
            //在 b = 0 时方程还要成立？ 使 x = 1, y = 0 ，必然成立
            d=a;//最大公约数
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

    static long gcd(long a, long b) {
        return b>0 ? gcd(b, a % b) : a;
    }
    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    static long a, b, A, B;

    static int  merge() {
        //如果不理解为什么 a和b的值继承关系看这个
        //https://www.luogu.com.cn/blog/blue/kuo-zhan-zhong-guo-sheng-yu-ding-li

        //公式推导看这个
        //https://www.luogu.com.cn/blog/KingSann/solution-p4777
        exgcd(a, A);
        long c = B - b;
        if((c % d)!=0){
            System.out.println(-1);
            return 0;
        }
        //d=gcd(a,A); 根据公式
        x = x * c / d % (A / d);
        //通解等于 特解+A/gcd(a,A)
        if(x < 0){ x += A / d;}
        //求出lcm(a,A) 这是一个累积的过程 这样才能满足剩余定理
        long mod = lcm(a, A);
        //套公式
        b = (a * x + b) % mod;
        //防止负数加个mod
        if(b < 0) {b += mod;}
        a = mod;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        PrintWriter cout=new PrintWriter(System.out);
        String s[];
        for(int i = 1 ; i <= n ; ++ i) {
            s=sc.readLine().split(" ");
            A=Long.parseLong(s[0]);
            B=Long.parseLong(s[1]);
            if(i > 1){
                if(merge()==0){
                      return;}
            }
            else {
                a = A;b = B;
            }
        }
        cout.printf("%d\n", (b % a));
        cout.close();
    }
}
