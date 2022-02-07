package com.example.coding.刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 23:02
 * @Version 1.0
 * @description:
 */
public class 三角形 {
    public static void main(String[] args) throws IOException {
        //それ以降の入力は無視して終了する
        Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans1=0;//三角形判定
        int ans2=0;//直角三角形
        int ans3=0;//钝角三角形
        int ans4=0;//锐角三角形
        int arr[]=new int[3];
        int n=5;
        String line;
        while ((line = br.readLine())!= null){
            String[] input = line.split(" " , 3);
            for(int i = 0; i < 3; i++)  arr[i] = Integer.parseInt(input[i]);
            int a=Integer.parseInt(input[0]),b=Integer.parseInt(input[1]),c=Integer.parseInt(input[2]);
            if(a+b>c&&a+c>b&&b+c>a){
                ans1++;
                arr[0]=a;
                arr[1]=b;
                arr[2]=c;
                Arrays.sort(arr);
                arr[0]=arr[0]*arr[0];
                arr[1]=arr[1]*arr[1];
                arr[2]=arr[2]*arr[2];
                //余弦定理判定
                if(arr[0]+arr[1]<arr[2]){
                    ans3++;
                }else if(arr[0]+arr[1]==arr[2]){
                    ans2++;
                }else{
                    ans4++;
                }
            }else{
                break;
            }
        }
        System.out.println(ans1+" "+ans2+" "+ans4+" "+ans3);
    }
}
