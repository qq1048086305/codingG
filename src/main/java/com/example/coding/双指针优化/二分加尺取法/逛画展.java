package com.example.coding.双指针优化.二分加尺取法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 15:46
 * @Version 1.0
 * @description:
 */
public class 逛画展 {
    static int N=1000100;
    static int M=2020;
    static int ansa,ansb,n,m;//尺子左边右边 可以理解为一个窗口左端点右端点
    static int a[]=new int[N];
    static int flag[]=new int[M];//记录在长度为p的区间，m个画师画的画有几幅
    static boolean isok(int p)
    {
        int i,tmp=0;
        Arrays.fill(flag,0);
        for (i=1;i<=p;i++){//先将1~p的画记下
            if (flag[a[i]]==0)//若有新出现的，出现个数tmp++
                tmp++;
            flag[a[i]]++;
        }
        if (tmp>=m) {//判断是否满足条件
            ansa=1;ansb=p;//更新答案
            return true;
        }
        for (i=p+1;i<=n;i++){//不断滑动窗口
            flag[a[i-p]]--;
            if (flag[a[i-p]]==0) tmp--;
            if (flag[a[i]]==0) tmp++;
            flag[a[i]]++;
            if (tmp>=m){
                ansa=i-p+1;ansb=i; //更新答案
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String[] s = sc.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        s=sc.readLine().split(" ");
        for(int i=1;i<=n;i++){
            a[i]=Integer.parseInt(s[i-1]);
        }
        int l,r,mid;
        l=0;r=n+2;
        while (l<r){
            mid=(l+r)>>1;
            if(isok(mid)){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        System.out.println(ansa+" "+ansb);
    }

}
