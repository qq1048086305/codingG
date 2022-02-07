package com.example.coding.归并;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/5 21:02
 * @Version 1.0
 * @description:
 */
public class KochCurve {

    static double M_PI=3.14159265358979323846;
    static class Point{
        double x, y;
    }

    static void koch(int n, Point a, Point b){
        if(n == 0) return;

        Point s=new Point(), t=new Point(), u=new Point();
        double th = M_PI * 60.0/180.0;//将单位从度变为弧度

        s.x = (2.0 * a.x + 1.0 * b.x) / 3.0;
        s.y = (2.0 * a.y + 1.0 * b.y) / 3.0;
        t.x = (1.0 * a.x + 2.0 * b.x) / 3.0;
        t.y = (1.0 * a.y + 2.0 * b.y) / 3.0;
        u.x = (t.x - s.x) * Math.cos(th) - (t.y - s.y) * Math.sin(th) + s.x;
        u.y = (t.x - s.x) * Math.sin(th) + (t.y - s.y) * Math.cos(th) + s.y;

        koch(n - 1, a, s);
        System.out.printf("%.8f %.8f\n", s.x, s.y);
        koch(n - 1, s, u);
        System.out.printf("%.8f %.8f\n", u.x, u.y);
        koch(n - 1, u, t);
        System.out.printf("%.8f %.8f\n", t.x, t.y);
        koch(n - 1, t, b);
    }
    public static void main(String[] args) {
        Point a=new Point(), b=new Point();
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        a.x = 0;
        a.y = 0;
        b.x = 100;
        b.y = 0;
        System.out.printf("%.8f %.8f\n", a.x, a.y);
        koch(n, a, b);
        System.out.printf("%.8f %.8f\n", b.x, b.y);
    }
}
