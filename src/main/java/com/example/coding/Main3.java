package com.example.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 10:24
 * @Version 1.0
 * @description:
 */
public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int []a=new int[11];
        for(int i=1;i<=10;i++){
            a[i]=Integer.parseInt(sc.readLine().trim());
        }
        Arrays.sort(a,1,11);
        for(int i=10;i>=8;i--){
            System.out.println(a[i]);
        }
    }
}
