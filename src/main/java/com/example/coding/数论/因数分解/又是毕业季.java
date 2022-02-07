package com.example.coding.数论.因数分解;

/**
 * @Author 神様だよ
 * @Date 2021/11/18 9:59
 * @Version 1.0
 * @description:
 */
import java.util.Scanner;


public class 又是毕业季 {
    static int n,t=0,c[]=new int[1000010];
    //c[i]表示i作为因子的次数
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            int x;x=sc.nextInt();
            t=Math.max(t,x);
            //记录目前最大能力值
            int m=(int) Math.sqrt(x);
            //能力值的开方
            for(int j=1;j<=m;j++)
                if(x%j==0)
                //有约数
                {
                    c[j]++;
                    //i作为因子的次数++
                    if(x!=j*j) c[x/j]++;
                    //如果x不是i的平方，x/i也是x的因子
                    //如果x是i的平方只记录i作为一次因子
                }
        }
        int x=t;
        for(int i=1;i<=n;i++)
        {
            while(c[x]<i) x--;
            System.out.println(x);
            //输出
        }
    }

}
