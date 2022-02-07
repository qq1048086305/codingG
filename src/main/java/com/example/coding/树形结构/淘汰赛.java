package com.example.coding.树形结构;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/15 15:40
 * @Version 1.0
 * @description:
 */
public class 淘汰赛 {
    static int a[]=new int[1<<7+1];
    static int n;
    //左区间右区间
    static int dfs(int l,int r)
    {
        if (l==r)
            {
                return l;
            }
        int mid=(l+r)/2;
        //递归下去找左半区间右半区间谁赢了 最后回来的时候 返回输的那个就是亚军
        int ll=dfs(l,mid),rr=dfs(mid+1,r);
        if (l!=1||r!=(1<<n))//如果不是最外层
        {
            if (a[ll]>a[rr])
                return ll;
            else
                return rr;
        }
        //如果是最外层，取输的一方
        if (a[ll]<a[rr])
            return ll;
        else
            return rr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        //数组模拟二叉树，两个方向找
        for (int i=1;i<=(1<<n);i++){
            a[i]=sc.nextInt();
        }
        System.out.println(dfs(1,1<<n));

    }

}
