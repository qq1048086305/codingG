package com.example.coding.数论.倍数筛选;

import java.util.Scanner;

public class PattingHeadsS {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n+1];
        int m=Integer.MIN_VALUE;
        //保存牛用用的数字
        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
            m=Math.max(m, arr[i]);
        }
        int b[]=new int[m+1];
        //对牛的数字用桶标记
        for(int i=1;i<=n;i++){
            b[arr[i]]++;
        }

        int ans[]=new int[m+1];
        //从1到数字最大值找对应的倍数 把每个数字能到的倍数标记到答案数组里 输出答案
        for(int i=1;i<=m;i++){
            if(b[i]==0){
                continue;
            }
            for(int j=1;j*i<=m;j++){
                ans[i*j]+=b[i];
            }
        }
        for(int i=1;i<=n;i++){
            System.out.println(ans[arr[i]]-1);
        }

    }

}
