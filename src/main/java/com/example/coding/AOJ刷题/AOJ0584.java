package com.example.coding.AOJ刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/3 12:42
 * @Version 1.0
 * @description:
 */
public class AOJ0584 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sc.readLine().trim());
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(sc.readLine().trim());
        }
        Arrays.sort(arr);
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<Math.min(4,n);i++){
            for(int j=0;j<Math.min(4,n);j++){
                if(i!=j){
                    list.add(Integer.parseInt(String.valueOf(arr[i])+String.valueOf(arr[j])));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.get(2));
    }
}
