package com.example.coding.数论.最大公约数欧几里得和最小公倍数;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Author 神様だよ
 * @Date 2021/11/17 16:23
 * @Version 1.0
 * @description:
 */
public class 字符串分数约分 {
    //放原字符串
    static char a[]=new char[101];
    //放数字
    static int b[]=new int[101],num,num1;
    static int gcd(int x,int y)
    {
        return y==0?x:gcd(y,x%y);
    }// 求最大公因数。
    static int ans=1;

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        a=sc.readLine().toCharArray();
        PrintWriter out=new PrintWriter(System.out);
        int lena=a.length;
        for(int i=0;i<lena;i++)
        {
            if(a[i]>='0'&&a[i]<='9')
            {
                b[num]=b[num]*10+a[i]-'0';
            }
            else num++;
        }// 把数字全都剥离开来，存放入一个新的数组中。
        for(int i=0;i<lena;i++)
        {
            if(a[i]=='+')
            {
                int p=2*num1;// ‘+’号和‘-’号一定出现在每四个数字的中间位置。
                num1++;
                // （分子1*分母2+分子2*分母1）/（分母1*分母2）,计算方法。
                b[p+2]=b[p]*b[p+3]*ans+b[p+2]*b[p+1];
                b[p+3]*=b[p+1];
                if(b[p+2]<0) {ans=-1;b[p+2]*=-1;}
                else ans=1;// 判负条件。
                //求出最大公约数化简
                int k=gcd(b[p+3],b[p+2]);
                while(k!=1)
                {
                    b[p+3]/=k;b[p+2]/=k;
                    k=gcd(b[p+3],b[p+2]);
                }
            }
            if(a[i]=='-')
            {
                int p=2*num1;
                num1++;
                b[p+2]=b[p]*b[p+3]*ans-b[p+2]*b[p+1];
                b[p+3]*=b[p+1];
                if(b[p+2]<0) {ans=-1;b[p+2]*=-1;}
                else ans=1;
                int k=gcd(b[p+3],b[p+2]);
                while(k!=1)
                {
                    b[p+3]/=k;b[p+2]/=k;
                    k=gcd(b[p+3],b[p+2]);
                }
            }
        }
        if(ans==-1) out.print('-');// 如果最终结果是负的，要先输出一个‘-’号。
        int k=gcd(b[2*num1],b[2*num1+1]);
        b[2*num1]/=k;b[2*num1+1]/=k;
        out.print(b[2*num1]);
        if(b[2*num1+1]!=1) out.print("/"+b[2*num1+1]);// 判断是否为整数输出。
        out.flush();
    }
}
