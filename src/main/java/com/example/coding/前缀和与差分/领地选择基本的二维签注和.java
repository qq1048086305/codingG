package com.example.coding.前缀和与差分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 14:49
 * @Version 1.0
 * @description:
 */
public class 领地选择基本的二维签注和 {
    static int maxn=1010;
    static int n,m,c,p[][]=new int[maxn][maxn],s[][]=new int[maxn][maxn],maxx=-0x7fffffff,xx,yy;

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedReader scc=new BufferedReader(new InputStreamReader(System.in));
        String[] split = scc.readLine().split("\\s+");
        n=Integer.parseInt(split[0]);
        m=Integer.parseInt(split[1]);
        c=Integer.parseInt(split[2]);
        for(int i=1;i<=n;++i){
            String[] split1 = scc.readLine().split("\\s+");
            for(int j=1;j<=m;++j)
            {
                p[i][j]=Integer.parseInt(split1[j-1]);
                s[i][j]=s[i-1][j]+s[i][j-1]-s[i-1][j-1]+p[i][j];
            }
        }
        //枚举首都右下角坐标
        for(int i=c;i<=n;++i)
            for(int j=c;j<=m;++j)
            {
                if(s[i][j]-s[i-c][j]-s[i][j-c]+s[i-c][j-c]>maxx)
                {
                    maxx=s[i][j]+s[i-c][j-c]-s[i-c][j]-s[i][j-c];
                    xx=i-c+1;yy=j-c+1;
                }
            }
        System.out.printf("%d %d",xx,yy);
    }
}
