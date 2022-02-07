package com.example.coding.贪心;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * @Author 神様だよ
 * @Date 2021/11/5 12:18
 * @Version 1.0
 * @description:
 */
public class 卡车装货 {
    static int N=100005;
    static int n;
    static int k;
    static int arr[]=new int[N];
    public static void main(String[] args) throws IOException {
        /**
         * 贪心失败 转为二分
         */
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String[] s = sc.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        k=Integer.parseInt(s[1]);
        long sum=0;
        for(int i=0;i<n;i++){
            int a=Integer.parseInt(sc.readLine().trim());
            arr[i]=a;
            sum+=a;
        }
        //这里不能排序 因为需要有序运输
        Arrays.sort(arr,0,n);
        long left=0;
        long right=sum;
        long mid=(left+right)>>1;
        long ans=sum;
        while (left<=right){
            if(check(mid)){
                right=mid-1;
                ans=Math.min(ans,mid);
            }else{
                left=mid+1;
            }
            mid=(left+right)>>1;
        }
        System.out.println(ans);


    }

    private static boolean check(long mid) {
        int count=k;
        long sum=0;
        int i=0;
        while (i<n){
            sum+=arr[i];
            if(mid>=sum&&count!=0){
                i++;
                continue;
            }else{
                count--;
                sum=0;
            }
            if(count<0){
                return false;
            }
        }
        return true;
    }
}
