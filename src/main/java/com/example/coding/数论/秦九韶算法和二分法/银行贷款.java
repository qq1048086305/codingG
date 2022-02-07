package com.example.coding.数论.秦九韶算法和二分法;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/14 11:07
 * @Version 1.0
 * @description:
 */
public class 银行贷款 {
    /**
     * 公式解析
     * https://www.luogu.com.cn/blog/McHf/p1163-doubly
     * @param args
     */
    //化简得后，用等比数列的求和公式得
    //[1/（1+ans)]^i=1-n/m*ans
    static double n,m,k,l,r;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();
        l=0;r=10;//月利率可能大于1
        //二分精度类型查找模板
        while(r-l>=0.0001){//注意精度问题
            double mid=(l+r)/2;
            if(pd(mid))r=mid;
            //没找到答案就放大去找
            else l=mid;
        }
        System.out.printf("%.1f",l*100);
    }
    //表示该贷款的月利率(用百分数表示)
    static boolean pd(double x){//判断当前答案是否满足
        return (Math.pow(1.0/(1.0+x),k)>=1-n/m*x);
    }

}
