package com.example.coding.acwing蓝桥杯.优化处理;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 16:15
 * @Version 1.0
 * @description:
 */

//https://www.acwing.com/solution/content/31983/
public class 激光炸弹二维前缀和 {
    /**
     *
     */
    static int f[][]=new int[5010][5010],n,m,r,c,x,y,z,i,j,ans;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        m=Math.min(5001,m);
        r=c=m;
        //m超过棋盘大小没意义
        for(i=1; i<=n; i++)
        {
            x=sc.nextInt();
            y=sc.nextInt();
            z=sc.nextInt();
            x++;
            y++;
            f[x][y]+=z;//坑点 可能叠加
            //找出最大横纵坐标 枚举用
            r=Math.max(r,x);
            c=Math.max(c,y);
        }
        solve();
    }

    private static void solve() {
        for(i=1; i<=r; i++){
            for(j=1; j<=c; j++){
                //二维前缀和
                f[i][j]=f[i-1][j]+f[i][j-1]-f[i-1][j-1]+f[i][j];
            }
        }
        for(i=m; i<=r; i++){
            for(j=m; j<=c; j++) {
                //算下边长m的正方形最大带来的和是多少
                ans=Math.max(ans,f[i][j]-f[i][j-m]-f[i-m][j]+f[i-m][j-m]);
            }
        }
        System.out.println(ans);
    }
}
