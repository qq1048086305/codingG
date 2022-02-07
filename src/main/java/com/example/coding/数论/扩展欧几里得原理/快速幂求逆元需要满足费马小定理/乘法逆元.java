package com.example.coding.数论.扩展欧几里得原理.快速幂求逆元需要满足费马小定理;

/**
 * @Author 神様だよ
 * @Date 2021/11/22 16:17
 * @Version 1.0
 * @description:
 */
public class 乘法逆元 {
    //求一个数a关于mod的逆元 mod是素数 a是正整数 快速幂+费马小定理
    static int mod=333;
    static int quick_pow(int ml,int nl)//快速幂
    {
        int s=1;
        while(nl>0)
        {
            if(nl%2==1)
            {
                s=(s%mod)*(ml%mod)%mod;
            }
            ml=ml*ml%mod;
            nl=nl>>1;
        }
        return s%mod;
    }

    public static void main(String[] args) {
        int a=2;
        long x=quick_pow(a,mod-2);
        System.out.println(x);
    }
}
