package com.example.coding.数论.解析几何数学;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/16 16:06
 * @Version 1.0
 * @description:
 */
public class 直线交点数 {
    //题解
    //https://www.luogu.com.cn/blog/yby39/solution-p2789
    static int n;
    //所以我们设f[i][j]为有i条直线时,交点数位j的情况存不存在
    static boolean f[][]=new boolean[30][900];
    //我们知道,n条互不平行直线且无三线共点,交点数为n*(n-1)/2
    //再根据,无三线共点这一条件,可以得出1条直线与n条直线不平行,
    // 那么它一定会与这n条直线交于n个点,如图,如果要保证无三条线交于一点,
    // 红线一定会与4条黑线交于4点(结论2)
    // 条(结论1).
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        //交点数位0一定存在
        for(int i=1;i<=n;i++) f[i][0]=true;//初始化
        //枚举直线数i,未放飞自我的直线数j,放飞自我的直线产生的交点数k,那么我们可以得出
        for(int i=2;i<=n;i++)//枚举i
        {
            for(int j=i-1;j>=1;j--)//枚举j
            {
                for(int k=0;k<=(i-j)*(i-j-1)/2;k++) f[i][j*(i-j)+k]=f[i][j*(i-j)+k]||f[i-j][k];//有i-j条直线由于最大交点数为(i-j)*(i-j-1)/2,所以就枚举到他就可以
            }
        }
        int ans=0;
        for(int i=0;i<=n*(n-1)/2;i++) if(f[n][i]) ans++;//计算方案数
        System.out.println(ans);
    }
}
