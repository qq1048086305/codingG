package com.example.coding.acwing蓝桥杯.优化处理;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 15:49
 * @Version 1.0
 * @description:
 */
public class 四平方和 {
    static HashMap<Integer,Integer> map=new HashMap<>();
    static int n;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        solve();
    }

    private static void solve() {
        //枚举大的
        for(int i=0;i*i*2<=n;i++){
            for(int j=0;(i*i+j*j)<=n;j++ ){
                if(!map.containsKey(i*i+j*j)){
                    map.put(i*i+j*j,i);//存一个对应的树
                }
            }
        }
        //枚举小的
        //c^2 + d^2 = n - a^2 - b^2枚举
        for(int i=0;i*i*4<=n;i++){
            for(int j=0;(i*i+j*j)*2<=n;j++){
                int x=i*i+j*j;
                if(map.containsKey(n-x)){
                    int c=map.get(n-x);
                    int d =(int) Math.sqrt(n - x - c * c);
                    System.out.println(i+" "+j+" "+c+" "+d);
                    return;
                }
            }
        }
    }
}
