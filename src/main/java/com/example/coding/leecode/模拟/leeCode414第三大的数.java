package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/6 19:28
 * @Version 1.0
 * @description:
 */
public class leeCode414第三大的数 {
    public int thirdMax(int[] nums) {
        long inf = Long.MIN_VALUE;
        //用a保存最大值，b保存次大值，c保存第三大值
        long a = inf,b = inf,c = inf,s=0;
        for(int x:nums){
            if(x>a){
                s++;
                c = b;
                b = a;
                a = x;
            }else if(x<a && x>b){
                s++;
                c = b;
                b = x;
            }else if(x<b && x>c){
                s++;
                c = x;
            }
        }
        if(s>=3)return (int)c;
        else return (int)a;
    }
}
