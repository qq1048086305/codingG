package com.example.coding.AOJ刷题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/3 13:47
 * @Version 1.0
 * @description:
 */
public class AOJ0586 {
    //枚举所有左边可能出现的数字(从大到小来枚举)然后反转拼上c后检查是否是素数就行了
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        if(c<0){
            if(n==1){
                System.out.println(11);
            }else{
                for(int i=0;i<2*n;i++){
                    System.out.print(9);
                }
                System.out.println();
            }
        }else{
            int a=1;
            //算出左半部分最大值 最后一位数最小为1
            for(int i=0;i<n;i++){
                a*=10;
            }
            int l=a/10;//最后的位数最多能变成多少 假如n=3 则 l=100 a=999->100;三位数素有可能性都考虑一边
            a--;//最后一位是9
            for(int i=a;i>=l;i--){
                if(check(i,c)){
                    return;
                }
            }
        }
    }

    private static boolean check(int a,int c) {
        //注意reverse的用法不能直接b1然后赋值因为反转后是本身地址的字符串反转了 比如说 b1来反转那么就会出现b1本身就被修改了new了也没用
        StringBuilder b1=new StringBuilder(a+"");
        StringBuilder b2=new StringBuilder(a+"").reverse();
        //b1+c+b2拼在一起
        b1.append(c).append(b2);
        if(prime(Integer.parseInt(b1.toString()))){
            System.out.println(b1);
            return true;
        }else{
            return false;
        }

    }

    private static boolean prime(int parseInt) {
        for(int i=2;i<=Math.sqrt(parseInt);i++){
            if(parseInt%i==0){
                return false;
            }
        }
        return true;
    }
}
