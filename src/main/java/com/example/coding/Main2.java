package com.example.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/3 22:32
 * @Version 1.0
 * @description:
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s[]=sc.readLine().split(" ");
            if(s[0].equals("E")){
                break;
            }
            double T=200,D=200,H=200;
            if(s[0].equals("T")){
                T=Double.parseDouble(s[1]);
            }else if(s[0].equals("H")){
                H=Double.parseDouble(s[1]);
            }else {
                D=Double.parseDouble(s[1]);
            }
            if(s[2].equals("T")){
                T=Double.parseDouble(s[3]);
            }else if(s[2].equals("H")){
                H=Double.parseDouble(s[3]);
            }else {
                D=Double.parseDouble(s[3]);
            }
            /**
             * humidex = temperature + h
             * h = (0.5555)× (e - 10.0)
             * e = 6.11 × exp [5417.7530 × ((1/273.16) - (1/(dewpoint+273.16)))]
             */
            if(D==200){
                double h=H-T;
                double e=h/0.5555+10.0;
                D=1/(1/273.16-Math.log(e/6.11)/5417.7530)-273.16;
            }else if(H==200){
                H=T+((0.5555)*(6.11*Math.exp(5417.7530*((1/273.16-(1/(D+273.16)))))-10.0));
            }else{
                T=H-(((0.5555)*(6.11*Math.exp(5417.7530*((1/273.16-(1/(D+273.16)))))-10.0)));
            }
            System.out.printf("T %.1f D %.1f H %.1f\n",T,D,H);

        }
    }
}
