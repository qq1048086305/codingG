package com.example.coding.acwing蓝桥杯.优化处理;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 16:28
 * @Version 1.0
 * @description:
 */
public class k倍区间 {
    static int N,K;
    static int a[]=new int[1000010];
    static int[] cnt = new int[100010];//记录余数是i的数有多少个

    /**
     * 因为第一个前缀和的余数是0的位置t的时候，
     * 从[1,t]的累加和是k的倍数，
     * 可以直接当做1个，
     * 如果第一个前缀和的余数是1的位置t的时候
     * ，那么[1,t1]的累加和就不算是k的倍数，这里就只能当做是0个，
     * 必须从第二个余数是1的位置t2开始，[t1 + 1,t2]的累加和才算第一个k的倍数
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        for(int i=1;i<=N;i++){
            a[i]=sc.nextInt();
            //前缀和数组
            a[i]=(a[i]%K+a[i-1]%K)%K;
        }
        long ans=0;
        cnt[0] = 1;//余数为0时，已经占一个
        /*for(int i=1;i<=N;i++){
            if(a[i]%K==0){
                ans++;
            }
            for(int j=i+1;j<=N;j++){
                    if( (a[j]-a[i])%K==0 ){
                        ans++;
                    }
            }
        }*/
        for(int i=1;i<=N;i++){
            ans+=cnt[a[i]];
            cnt[a[i]]++;
        }
        System.out.println(ans);
    }
}
