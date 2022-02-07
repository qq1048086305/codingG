package com.example.coding.前缀和与差分;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 13:43
 * @Version 1.0
 * @description:
 */
public class 海底高铁 {
    //c是差分数组 记录每一段对应的次数
    static int n,m,p,c[]=new int[100005],p2,p1,a,b,c1;
    static long sum,ans;
    //本题可以使用差分数组和前缀和求出每一段需要经过的次数
    // 再用贪心策略在2种买票方式中选择

    /**
     * 由于我们是正着遍历的，所以当你从数字较大的城市到小的城市，
     * 数字大的减一，小的加1，这样我们经过小的城市的时候我们就知道接下来的那段铁路是被经过了多少次，
     * 而到了减一的城市之后接下来经过的铁路就不受刚才路牌的影响，因为原来加的被减了呀。
     *
     * 所以关键在于如何构建路牌，这是一维的构建方法，
     * 二维也有他的构建方法，而且对于二维而言，路牌的作用就更加显著了。
     * @param args
     */
    public static void main(String[] args) {
        //long time1 = System.currentTimeMillis();
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        if(m>0)p1=sc.nextInt();
        for(int i=2;i<=m;i++)
        {
            p2=sc.nextInt();
            if(p1<p2){c[p1]++;c[p2]--;}
            else {c[p2]++;c[p1]--;}
            p1=p2;
        }
        for(int i=1;i<n;i++)
        {
            sum+=c[i];
            a=sc.nextInt();
            b=sc.nextInt();
            c1=sc.nextInt();
            if(sum!=0)ans+=Math.min(a*sum,b*sum+c1);
        }
        if(m<=1)ans=0;
        System.out.println(ans);
        /*long time2 = System.currentTimeMillis();
        int time = (int) ((time2 - time1)/1000);
        System.out.println("执行了："+time+"秒！");*/
    }
}
