package com.example.coding.leecode.数论.快速幂;

import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2022/1/1 21:00
 * @Version 1.0
 * @description:
 */
public class leecode371超级次方 {
    //快速幂加上 幂运算原理(递归拆数)
    static int base = 1337;
    public int superPow(int a, int[] b) {
        if(b.length==0){
            return 1;
        }
        int cur=b[b.length-1];
        int newArr[]=new int[b.length-1];
        for(int i=0;i<b.length-1;i++){
            newArr[i]=b[i];
        }
        return quickPow(a,cur)*quickPow(superPow(a,newArr),10)%base;
    }


    public static int quickPow(int a, int b) //快速幂
    {
        a %= base;
        int res = 1;
        for (int i = 0; i < b; ++i) res = (res * a) % base; //最多计算10次
        return res;
    }
}
