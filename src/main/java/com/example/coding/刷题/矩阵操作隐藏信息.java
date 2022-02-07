package com.example.coding.刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 16:05
 * @Version 1.0
 * @description:
 */
public class 矩阵操作隐藏信息 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sc.readLine());
        char s[][]=new char[n][n];
        char t[][]=new char[n][n];
        for(int i=0;i<n;i++){
            s[i]=sc.readLine().toCharArray();
        }
        for(int i=0;i<n;i++){
            t[i]=sc.readLine().toCharArray();
        }
        int i,j;
        int cnt1,cnt2,cnt3,cnt4,min = 0;
        cnt1=0;
        //不旋转
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(s[i][j]!=t[i][j]) cnt1++;
            }
        }

        cnt2=1;
        //逆时针旋转90
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(s[j][n-1-i]!=t[i][j]) cnt2++;
            }
        }
        //顺时针旋转90
        cnt3=1;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(s[n-1-j][i]!=t[i][j]) cnt3++;
            }
        }
        //倒过来 转两次
        cnt4=2;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(s[n-1-i][n-1-j]!=t[i][j]) cnt4++;
            }
        }
        //最优解一定在这4种操作中 因为转会转回去情况会重复
        if(cnt1<=cnt2 && cnt1<=cnt3 && cnt1<=cnt4) min=cnt1;
        if(cnt2<=cnt1 && cnt2<=cnt3 && cnt2<=cnt4) min=cnt2;
        if(cnt3<=cnt1 && cnt3<=cnt2 && cnt3<=cnt4) min=cnt3;
        if(cnt4<=cnt1 && cnt4<=cnt2 && cnt4<=cnt3) min=cnt4;

        System.out.printf("%d\n",min);
    }
}
