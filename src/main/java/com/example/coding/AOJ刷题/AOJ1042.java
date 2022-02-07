package com.example.coding.AOJ刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/12/4 10:55
 * @Version 1.0
 * @description:
 */
public class AOJ1042 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s=sc.readLine();
            if(s.equals("END OF INPUT")){
                return;
            }
            String[] s1 = s.split(" ");
            String ss="";
            //注意分了之后多余空格会变成“”；
            for(int i=0;i<s1.length;i++){
                if(s1[i].equals("")){
                    ss+="0";
                }else{
                    ss+=s1[i].length();
                }
            }
            System.out.println(ss);

        }
    }
}
