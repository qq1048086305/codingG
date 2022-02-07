package com.example.coding.数论.排列组合.容斥定理;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/25 15:33
 * @Version 1.0
 * @description:
 */
public class 硬币购物 {
    //https://www.luogu.com.cn/blog/rainhand/p1450-haoi2008-ying-bi-gou-wu
    static int S=100009;
    static long f[]=new long[S];

    public static void main(String[] args) {
        int c[]=new int[4],d[]=new int[4],tot,i,j,k,now,s,ss,tmp;
        long ans;
        PrintWriter cout=new PrintWriter(System.out);
        Scanner sc=new Scanner(System.in);
        for(j=0;j<4;++j)c[j]=sc.nextInt();
        tot=sc.nextInt();
        for(j=0;j<4;++j)
            for(i=c[j];i<S;++i)
                f[i]+=f[i-c[j]];//完全背包预处理
        while(tot-->0){
            for(j=0;j<4;++j)d[j]=sc.nextInt();
            s=sc.nextInt();
            ans=f[s];
            for(ss=1;ss<=15;++ss){//二进制数枚举集合，容斥
                now=s;
                for(tmp=ss,j=k=0;tmp>0;tmp>>=1,++j)
                    if((tmp&1)==1){k^=1;now-=(d[j]+1)*c[j];}
                //注意k的作用，判断奇偶
                if(now>=0){
                    if(k==1){
                        ans-=f[now];
                    }else{
                        ans+=f[now];
                    }
                }
            }
            cout.printf("%d\n",ans);
            cout.close();
        }
    }
}
