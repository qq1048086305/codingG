package com.example.coding.归并;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/12 20:40
 * @Version 1.0
 * @description:
 */
public class 南蛮图腾 {
    /**
     * 向右复制一次 向上复制一次
     */
    static char a[][]=new char[1024][2048];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,length=4,k=1;//length表示当前图腾的宽，length/2是图腾的高
        n=sc.nextInt();
        for(int i=0;i<1024;i++)
            for(int j=0;j<2048;j++)
                a[i][j]=' ';//先全部置为空格(反正忽略行末空格2333)
        a[0][0]=a[1][1]='/';
        a[0][1]=a[0][2]='_';
        a[0][3]=a[1][2]='\\';//存n=1时的基础图腾（倒着的）
        while(k<n)//不断复制
        {
            for(int i=0;i<length/2;i++)
                for(int j=0;j<length;j++)
                    a[i+(length/2)][j+(length/2)]=a[i][j+length]=a[i][j];

            length*=2;
            k++;
        }
        for(int i=(length/2)-1;i>=0;i--)//倒序输出
        {
            for(int j=0;j<length;j++)
                System.out.print(a[i][j]);
            System.out.println();
        }
    }


}
