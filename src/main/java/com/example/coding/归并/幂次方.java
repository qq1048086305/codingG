package com.example.coding.归并;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/12 17:41
 * @Version 1.0
 * @description:
 */
public class 幂次方 {
    //认真看，杜绝抄袭
    static void ASCII(int m)
    {
        int i=0,k=m,u=0,h[]=new int[50];
        while(k>0)//位运算实现；
        {
            if((k&1)==1)h[++u]=i;
            //h[++u]相当于++u，h[u]……
            k>>=1;
            i++;
        }
        //据上面写的，u从1开始，无论如何一定会有输出；
        while(u>0)//u为真
        {
            if(h[u]<3)//具体括号判断；
            {
                if(h[u]==1 && u-1!=0)  System.out.printf("2+");
                else if(h[u]==1)	   System.out. printf("2");

                if((h[u]==0||h[u]==2)&&(u-1!=0))   System.out.printf("2(%d)+",h[u]);
                else if(h[u]==0||h[u]==2)		   System.out.printf("2(%d)",h[u]);
                --u;//搜索下一个；
            }
            else
            {
                System.out.printf("2(");
                ASCII(h[u--]);
                //相当于h[u],--u;
                //这里千万不能写成 h[--u],否则你会3个WA两个MLE；
                if(u!=0) System.out.printf(")+");
                    //由于u进行了自减，此时的u已经是下一个数了；
                else  System.out.printf(")");
                //判断括号；
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        dfs(n);
    }
    public static void dfs(int m){
        //i代表2的幂次方
        //刚开始是2的0次方
        int i=0,k=m,u=0,h[]=new int[50];
        while (k>0){
            if((k&1)==1){
                h[++u]=i;
            }
            //从右往左找下一位,
            k>>=1;
            i++;
        }
        //开始从大到小 分解2的次方
        while (u>0){
            //分治到最小的情况
           if(h[u]<3){
               if(h[u]==1&&u-1!=0){
                   //后面还有带个加号
                   System.out.printf("2+");
               }else if(h[u]==1){
                   System.out. printf("2");
               }
               if((h[u]==2||h[u]==0)&&u-1!=0){
                   System.out.printf("2(%d)+",h[u]);
               }else if((h[u]==2||h[u]==0)){
                   System.out.printf("2(%d)",h[u]);
               }
               u--;//找下一个数喽
           }else{//需要往h[u]<3靠的情况
               System.out.print("2(");
               //这边递归所有情况都算出来了
               dfs(h[u]);
               u--;
               if(u!=0){
                   System.out.print(")+");
               }else {
                   System.out.print(")");
               }
           }
        }
    }
}
