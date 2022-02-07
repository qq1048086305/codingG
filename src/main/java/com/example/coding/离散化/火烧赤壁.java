package com.example.coding.离散化;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 8:21
 * @Version 1.0
 * @description:
 */
public class 火烧赤壁 {
    static int n,m=1;//m记录坐标数
    static long ans=0;
    static long c[]=new long[40100];
    //因为c要把起点与终点存下来，所以开40100
    static int a[]=new int[20100],b[]=new int[20100];//a存起点，b存终点
    static boolean flag[]=new boolean[40100];//判断是否有效
    static long find(long key)//找原来位置
    {
        for(int i=1;i<=m;++i)
        {
            if(c[i]==key)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine().trim());
        PrintWriter out=new PrintWriter(System.out);
        //long型数据放到c里面离散化
        for(int i=1;i<=n;++i)
        {   String s[]=sc.readLine().split(" ");
            a[i]=Integer.parseInt(s[0]);
            b[i]=Integer.parseInt(s[1]);
            c[m]=a[i];
            m++;
            c[m]=b[i];
            m++;
        }
        //把a,b存入c数组里去
        Arrays.sort(c,1,m+1);//排序坐标
        for(int i=1;i<=n;++i)
        {   //找到对应a[i] b[i]在c数组中离散化后下标
            a[i]=(int)find(a[i]);
            b[i]=(int)find(b[i])-1;//找原位置
            for(int j=a[i];j<=b[i];++j)
                flag[j]=true;//为有效
        }
        for(int i=1;i<=m;++i)
        {
            if(flag[i])
                ans+=c[i+1]-c[i];//有效，加入ans
        }
        out.printf("%d",ans);
        out.flush();
    }
}
