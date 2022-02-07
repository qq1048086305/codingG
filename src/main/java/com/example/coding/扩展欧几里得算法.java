package com.example.coding;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 12:19
 * @Version 1.0
 * @description:
 */
public class 扩展欧几里得算法 {
    /**
     * 假设当前我们要处理的是求出 a 和 b的最大公约数，并求出 x 和 y 使得 a*x + b*y= gcd ，而我们已经求出了下一个状态：b 和 a%b 的最大公约数，并且求出了一组x1 和y1 使得： b*x1 + (a%b)*y1 = gcd ， 那么这两个相邻的状态之间是否存在一种关系呢？
     *
     *     我们知道： a%b = a - (a/b)*b（这里的 “/” 指的是整除，例如 5/2=2 , 1/3=0），那么，我们可以进一步得到：
     *
     *         gcd = b*x1 + (a-(a/b)*b)*y1
     *
     *             = b*x1 + a*y1 – (a/b)*b*y1
     *
     *             = a*y1 + b*(x1 – a/b*y1)
     *
     *     对比之前我们的状态：求一组 x 和 y 使得：a*x + b*y = gcd ，是否发现了什么？
     *
     *     这里：
     *
     *         x = y1
     *
     *         y = x1 – a/b*y1
     */
    static int x,y;
    static int e_gcd(int a,int b){
        if(b==0){
            x=1;
            y=0;
            return a;
        }
        int ans=e_gcd(b,a%b);
        int tmp=x;
        x=y;
        y=tmp-a/b*y;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        e_gcd(sc.nextInt(),sc.nextInt());
        System.out.println(x+" "+y);
    }
}
