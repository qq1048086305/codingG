package com.example.coding;

import java.util.*;

/**
 * @Author 神様だよ
 * @Date 2021/11/9 13:23
 * @Version 1.0
 * @description:
 */
public class Tewst5 {
    static int maxn=(int)1e4+10;
    static int n,tot,w,h;
    static int yy[]=new int[maxn<<1];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=0;
        t=sc.nextInt();
        while (t-->0){
            n=sc.nextInt();
            w=sc.nextInt();
            h=sc.nextInt();
            for(int i=1;i<=n;i++)
            {
                int x,y,c;
                x=sc.nextInt();
                y=sc.nextInt();
                c=sc.nextInt();
                yy[i]=y+h-1;
                yy[i+n]=y;
            }
            n<<=1;//处理的是2n条线段
            Arrays.sort(yy, 1, n+1);
            int tot = 0;
            yy[0]=-99999;
            //去重  离散化
            for (int i = 1; i <= n; i++) {
                if (yy[i] != yy[tot]) {
                    yy[++tot] = yy[i];
                }
            }
            System.out.println(tot);
        }

    }
}
