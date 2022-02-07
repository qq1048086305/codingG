package com.example.coding.Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 22:52
 * @Version 1.0
 * @description:
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sc.readLine().trim());
        String[] s = sc.readLine().split(" ");
        Set<String> set=new HashSet<>();
        int ans=0;
        Set<String> set2=new HashSet<>();
        for (String s1 : s) {
            {
                set.add(s1);
            }
        }
        int m=Integer.parseInt(sc.readLine().trim());
        String[] s1 = sc.readLine().split(" ");
        for (String s2 : s1) {
            if(set.contains(s2)&&!set2.contains(s2)){
                set2.add(s2);
            }else {
            }
        }
        System.out.println(set2.size());
    }

}
