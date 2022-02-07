package com.example.coding.leecode.数论.因子质数;

/**
 * @Author 神様だよ
 * @Date 2022/1/22 9:51
 * @Version 1.0
 * @description:
 */
public class LeeCode507完美数 {
    public boolean checkPerfectNumber(int num) {
        //试除法
        /**
         * 若一个数n是一个合数，必然存在2个因子dd,ndnd，假设dd <= ndnd，则dd <= n√n，因此必然存在一个小于等于 n√n的因子
         */
        int res = 0;
        for(int i = 1;i * i < num;i ++)
        {
            if(num % i == 0)
            {
                res += i;
                if(i != 1 && num / i != i) res += num / i;
            }

        }
        return res == num;
    }

}
