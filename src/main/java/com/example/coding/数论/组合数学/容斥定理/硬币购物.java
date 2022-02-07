package com.example.coding.数论.组合数学.容斥定理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/29 15:43
 * @Version 1.0
 * @description:
 */
public class 硬币购物 {
    //https://www.luogu.com.cn/blog/virus2017/solution-p1450
    static int S=100009;
    static long f[]=new long[S];
    static int T,n,c[]=new int[5],d[]=new int[5],s;
    static long ans;
    static void pack_pre()
    {
        f[0]=1;
        for(int i=1;i<=4;i++)
            for(int j=c[i];j<=100001;j++)
                f[j]+=f[j-c[i]];
    }
    static void dfs(int now,int sum,int flag)
     //now是现在搜到的硬币种类
     //sum是目前还能用的金额数目
     //flag是符号（控制+,-符号）
    {
        if(sum<0) return;//能用的钱没了就返回
        if(now>4) {ans+=f[sum]*flag;return;}//所有硬币种类都搜完了
        dfs(now+1,sum,flag);//合法的部分
        dfs(now+1,sum-(d[now]+1)*c[now],-flag);//不合法的部分
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader( new InputStreamReader(System.in));
        PrintWriter cout=new PrintWriter(System.out);
        String s[]=sc.readLine().split(" ");
        for(int i=1;i<=4;i++) c[i]=Integer.parseInt(s[i-1]);
        pack_pre();//完全背包预处理
        T=Integer.parseInt(s[4]);
        while(T-->0)
        {
            ans=0;//记得清零
            s=sc.readLine().split(" ");
            for(int i=1;i<=4;i++) d[i]=Integer.parseInt(s[i-1]);
            int ss=Integer.parseInt(s[4]);
            dfs(1,ss,1);
            cout.printf("%d\n",ans);
            cout.flush();
        }
    }
}
