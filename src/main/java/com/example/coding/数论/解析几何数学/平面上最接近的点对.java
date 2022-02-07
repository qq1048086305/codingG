package com.example.coding.数论.解析几何数学;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/21 9:28
 * @Version 1.0
 * @description:
 */
public class 平面上最接近的点对 {
    static int x[]=new int[10005],y[]=new int[10005];
    static int n;
    static double ans=100000000;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        PrintWriter out=new PrintWriter(System.out);
        for(int i=1;i<=n;i++){
            x[i]=sc.nextInt();
            y[i]=sc.nextInt();
            for(int j=i-1;j>=1;j--){//这里每一次输入只要和前面几次比较，可以节省一些时间
                int aa=(x[i]-x[j])*(x[i]-x[j]),bb=(y[i]-y[j])*(y[i]-y[j]);
                if(Math.sqrt(aa+bb)<ans)ans=Math.sqrt(aa+bb);//勾股定理强算
            }

        }
        out.printf("%.4f",ans);
        out.flush();
    }

}
