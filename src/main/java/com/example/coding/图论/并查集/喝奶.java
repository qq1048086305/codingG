package com.example.coding.图论.并查集;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 8:42
 * @Version 1.0
 * @description:
 */
public class 喝奶 {
    //思路 用个并查集 相同颜色放在一个连通块里面 查询的时候如果在一个连通块 判断一下颜色是否符合要求，
    //两个连通块肯定符合要求 但是这种思路如果有3个颜色就不好弄了
    static int fa[]=new int[100010],ans[]=new int[100010],M,N;
    static char col[]=new char[100010];
    static int find(int x)
    {
        if(x==fa[x])	return x;
        return fa[x]=find(fa[x]);
    }
    static void merge(int x,int y)
    {
        fa[find(x)]=find(y);
    }

    public static void main(String[] args) throws IOException {
        int cnt=0;
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split(" ");
        N=Integer.parseInt(s[0]);
        M=Integer.parseInt(s[1]);
        PrintWriter out=new PrintWriter(System.out);
        char[] chars=sc.readLine().toCharArray();
        for(int i=1;i<=N;i++)
        {
            fa[i]=i;
            col[i]=chars[i-1];
        }
        for(int i=1;i<=N-1;i++)
        {   s=sc.readLine().split(" ");
            int u,v;
            u=Integer.parseInt(s[0]);
            v=Integer.parseInt(s[1]);
            //连通块相同就连在一起
            if(col[u]==col[v])	merge(u,v);
        }
        for(int i=1;i<=M;i++)
        {   s=sc.readLine().split(" ");
            int a,b;
            a=Integer.parseInt(s[0]);
            b=Integer.parseInt(s[1]);
            char c;
            c=s[2].charAt(0);
            if(find(a)==find(b)&&col[a]!=c)		ans[++cnt]=0;//判断路径上是否有偏好的牛奶
            else	ans[++cnt]=1;
        }
        for(int i=1;i<=cnt;i++)	out.print(ans[i]);
        out.close();
    }
}
