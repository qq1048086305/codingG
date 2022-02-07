package com.example.coding.双指针优化;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 13:31
 * @Version 1.0
 * @description:
 */
public class CollectorS {
    static int N=50077;
    static int n,k;
    static int a[]=new int[N],ansl[]=new int[N],ansr[]=new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        k=Integer.parseInt(s[1]);
        for(int i=1;i<=n;++i) {
            a[i]=Integer.parseInt(sc.readLine().trim());
        }
        //从小到大排序
        Arrays.sort(a,1,n+1);
        int l=1,r=n;
        //从左往右扫一遍记录答案
        for(int i=1;i<=n;++i){
            while(a[i]-a[l]>k&&l<=i) l++;
            ansl[i]=Math.max(ansl[i-1],i-l+1);
        }
        //从右往左扫一遍记录答案
        for(int i=n;i>=1;--i){
            while(a[r]-a[i]>k&&r>=i) r--;
            ansr[i]=Math.max(ansr[i+1],r-i+1);
        }
        int ans=0;
        for(int i=1;i<n;++i)
            ans=Math.max(ans,ansl[i]+ansr[i+1]);
        System.out.println(ans);
    }
}
