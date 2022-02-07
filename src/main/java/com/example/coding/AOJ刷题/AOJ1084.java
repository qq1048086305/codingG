package com.example.coding.AOJ刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/12/6 13:21
 * @Version 1.0
 * @description:
 */
public class AOJ1084 {
    //注意这题不是规定只能在最大值出现连续区间内交换 是所有范围内所以要枚举一遍
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s[]=sc.readLine().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            if(n==0&&k==0){
                break;
            }
            int sum=Integer.MIN_VALUE;
            //比如k=2 r从下标2开始找max
            int l=-1,r=l+k;
            int L=0,R=0;
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(sc.readLine().trim());
            }
            while (l<arr.length-1&&r<arr.length){
                int sum2=1;
                for(int i=l+1;i<=r;i++){
                    sum2*=arr[i];
                }
                if(sum2>sum){
                    sum=sum2;
                    L=l;
                    R=r;
                }
                l++;
                r++;
            }
            int sum2=1;
            for(int i=0;i<arr.length;i++){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[i]==arr[j]){
                        continue;
                    }
                    int tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                    l=-1;
                    r=l+k;
                    while (l<arr.length-1&&r<arr.length){
                        int sum3=1;
                        for(int m=l+1;m<=r;m++){
                            sum3*=arr[m];
                        }
                        if(sum3>sum2){
                            sum2=sum3;
                            L=l;
                            R=r;
                        }
                        l++;
                        r++;
                    }
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
            if(sum2-sum<0){
                System.out.println("0");
            }else{
                System.out.println(sum2-sum);
            }
        }
    }
}
