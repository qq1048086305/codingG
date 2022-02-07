package com.example.coding.归并;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/12 19:04
 * @Version 1.0
 * @description:
 */
public class 铺毯子 {
    /**
     *
     */
    static long x,y,len; static int k;
    static long fun(int k)
    {
        long sum=1;
        for(int i=1;i<=k;++i) sum*=2;
        return sum;
    }

    /**
     *
     * @param x  公主在的横坐标位置
     * @param y  公主在的纵坐标
     * @param a  当前块的左上角横坐标
     * @param b  此条件下的起点纵坐标
     * @param l  当前总宽度
     */
    //每次都去考虑在最中间的位置的4个格子上放一个地毯 相当于造一个新公主当然 如果公主原来就在 那么公主在的4分之一格子只需要/2递归就行了，
    //所以我们每一个递归都要考虑公主在的为自豪
    static void solve(long x,long y,long a,long b,long l)
    {   //如果1个格子就return
        if(l==1) return;
        //都当成4个格子处理 公主在左上角的情况
        if(x-a<=l/2-1 && y-b<=l/2-1)
        {
            System.out.printf("%d %d 1\n",a+l/2L,b+l/2L);
            solve(x,y,a,b,l/2);
            solve(a+l/2-1,b+l/2,a,b+l/2,l/2);
            solve(a+l/2,b+l/2-1,a+l/2,b,l/2);
            solve(a+l/2,b+l/2,a+l/2,b+l/2,l/2);
        }
        //公主在左下角
        else if(x-a<=l/2-1 && y-b>l/2-1)
        {
            System.out.printf("%d %d 2\n",a+l/2L,b+l/2-1L);
            solve(a+l/2-1,b+l/2-1,a,b,l/2);
            solve(x,y,a,b+l/2,l/2);
            solve(a+l/2,b+l/2-1,a+l/2,b,l/2);
            solve(a+l/2,b+l/2,a+l/2,b+l/2,l/2);
        }
        //公主在右上角
        else if(x-a>l/2-1 && y-b<=l/2-1)
        {
            System.out.printf("%d %d 3\n",a+l/2-1L,b+l/2L);
            solve(a+l/2-1,b+l/2-1,a,b,l/2);
            solve(a+l/2-1,b+l/2,a,b+l/2,l/2);
            solve(x,y,a+l/2,b,l/2);
            solve(a+l/2,b+l/2,a+l/2,b+l/2,l/2);
        }
        else////公主在右下角
        {
            System.out.printf("%d %d 4\n",a+l/2-1L,b+l/2-1L);
            solve(a+l/2-1,b+l/2-1,a,b,l/2);
            solve(a+l/2-1,b+l/2,a,b+l/2,l/2);
            solve(a+l/2,b+l/2-1,a+l/2,b,l/2);
            solve(x,y,a+l/2,b+l/2,l/2);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        k=sc.nextInt();
        x=sc.nextLong();
        y=sc.nextLong();
        len=fun(k);
        solve(x,y,1,1,len);
    }


}
