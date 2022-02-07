package com.example.coding.acwing蓝桥杯.树状数组和线段树;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/19 17:08
 * @Version 1.0
 * @description:
 */
public class 小朋友排队逆序对 {

    static int N = 1000010;
    static int n;
    static int a[]=new int[N];
    static long tr[]=new long[N],b[]=new long[N];

    static int lowbit(int x){
        return x&-x;
    }

    static void add(int x,int y){
        for(int i=x;i<N;i+=lowbit(i)) tr[i]+=y;
    }

    static int query(int x){
        int ans=0;
        for(int i=x;i>0;i-=lowbit(i)) ans+=tr[i];
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=n;i++){
            a[i]=sc.nextInt();
            a[i]++; //避免0
        }
        for(int i=1;i<=n;i++){
            add(a[i],1);
            b[i]=(i)-query(a[i]); //比这个数大的个数
        }
        // cout<<endl;

        Arrays.fill(tr,0); //该逆序算了，所以维护树状数组不一样，所以算完大的要清0.

        for(int i=n;i>=1;i--){
            add(a[i],1);
            b[i]+=query(a[i]-1);  //比这个数小
        }
        long res=0;
        for(int i=1;i<=n;i++){
            /**
             * b数组维护的是每个小朋友换位的次数，
             * 所以每次要用等差数列先算出每个小朋友的不开心程度，然后累加
             */
            res+=(1+b[i])*b[i]/2;
        }
        System.out.println(res);
    }
}
