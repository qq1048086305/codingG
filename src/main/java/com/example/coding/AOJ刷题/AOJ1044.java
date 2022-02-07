package com.example.coding.AOJ刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/4 22:26
 * @Version 1.0
 * @description:
 */
public class AOJ1044 {
    //字符串大小写划分与转换
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String str, input;

        while(true){
            String[] s = sc.readLine().split(" ");
            str = s[0];
            input = s[1];

            if(input.charAt(0) == 'X') break;

            String change = "";
            String[]column = str.split("_");

            switch(input.charAt(0)){
                case 'U':
                    if(column.length == 1){
                        change = (char)(str.charAt(0)&(~32)) + str.substring(1);
                    }else{
                        for(int i = 0; i < column.length; i++){
                            change += (char)(column[i].charAt(0)&(~32)) + column[i].substring(1);
                        }
                    }
                    break;
                case 'L':
                    if(column.length == 1){
                        change = (char)(str.charAt(0)|(32)) + str.substring(1);
                    }else{
                        change += column[0];
                        for(int i = 1; i < column.length; i++){
                            change += (char)(column[i].charAt(0)&(~32)) + column[i].substring(1);
                        }
                    }
                    break;
                case 'D':
                    if(column.length !=1 ) change = str;
                    else for(int i = 0; i < str.length(); i++){
                        if(i > 0 && str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                            change += "_"+(char)(str.charAt(i)|32);
                        }
                        else change += (char)(str.charAt(i)|32);
                    }
                    break;
            }
            System.out.println(change);
        }
    }
}
