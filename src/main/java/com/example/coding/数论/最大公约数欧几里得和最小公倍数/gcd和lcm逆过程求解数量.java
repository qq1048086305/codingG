package com.example.coding.数论.最大公约数欧几里得和最小公倍数;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/17 12:50
 * @Version 1.0
 * @description:
 */
public class gcd和lcm逆过程求解数量 {
    /**
     * https://www.luogu.com.cn/blog/zzlzk/solution-p1072
     */
    static int gcd(int a,int b) {
        return b==0?a:gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0) {
            int a0,a1,b0,b1;
            a0=sc.nextInt();
            a1=sc.nextInt();
            b0=sc.nextInt();
            b1=sc.nextInt();
            int p=a0/a1,q=b1/b0,ans=0;
            for(int x=1;x*x<=b1;x++)
                if(b1%x==0){
                    if(x%a1==0&&gcd(x/a1,p)==1&&gcd(q,b1/x)==1) ans++;
                    int y=b1/x;//得到另一个因子
                    if(x==y) continue;
                    if(y%a1==0&&gcd(y/a1,p)==1&&gcd(q,b1/y)==1) ans++;
                }
            System.out.printf("%d\n",ans);
        }
    }
}
