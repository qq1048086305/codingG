package com.example.coding.数论.质因数分解快速幂费马定理;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/18 13:55
 * @Version 1.0
 * @description:
 */
public class 因子和 {
    //https://www.luogu.com.cn/blog/dgsyrc/solution-p1593
    static int a,b,sa,arr[][]=new int[10010][2],cot=0,ans=1;
    static int mod=9901;
    static int quick_pow(int ml,int nl)//快速幂
    {
        int s=1;
        while(nl>0)
        {
            if(nl%2==1)
            {
                s=(s%mod)*(ml%mod)%mod;
            }
            ml=ml*ml%mod;
            nl=nl>>1;
        }
        return s%mod;
    }

    static int sum(int x,int y)
    {
        int k=0;
        y=y*b;
        if(x%mod==1)
        {
            k=(y+1)%mod;//当逆元不存在时
        }
        else
        {
            k=(quick_pow(x%mod,y+1)-1)%mod*quick_pow((x-1)%mod,mod-2)%mod;//当逆元存在时
        }

        return k%mod;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        if(a==0)//特判，0的因数和就是0
        {
            System.out.printf("0\n");
            return ;
        }
        for(int i=2;i*i<=a;i++)//分解质因数
        {
            if(a%i==0)
            {
                cot++;
                arr[cot][0]=i;//记录质因数
                arr[cot][1]=1;//记录幂次
                a=a/i;
                while(a%i==0)
                {
                    arr[cot][1]++;//记录幂次
                    a=a/i;
                }
            }
        }
        if(a!=1)//可能a仍为因子
        {
            cot++;
            arr[cot][0]=a;
            arr[cot][1]=1;
        }
        for(int i=1;i<=cot;i++)
        {
            ans=ans*sum(arr[i][0],arr[i][1])%mod;
        }
        System.out.printf("%d\n",(ans%mod+mod)%mod);
        return;
    }
}
