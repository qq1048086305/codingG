package com.example.coding.acwing蓝桥杯.数学;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 17:01
 * @Version 1.0
 * @description:
 */
public class 买不到的数目 {
    static int x,y;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        System.out.println((x-1)*(y-1)-1);
    }

    private static boolean dfs(int target, int x, int y) {
        if(target==0){
            return true;
        }
        if(target>=x&&dfs(target-x,x,y)){
            return true;
        }
        if(target>=y&&dfs(target-y,x,y)){
            return true;
        }
        return false;
    }
}
