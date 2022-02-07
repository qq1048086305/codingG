package com.example.coding.leecode.二进制枚举;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/4 20:56
 * @Version 1.0
 * @description:
 */
public class leecode401二进制手表 {
    public List<String> readBinaryWatch(int num) {
        List<String> res=new LinkedList<>();
        //枚举10位所有可能的情况
        for(int i=0;i<1<<10;i++){
            int s=0;
            for(int j=0;j<10;j++)
                if((i>>j&1)==1) s++;
            if(s==num){
                //判断时间是否合法
                int a=i>>6;//右移6位就变成了只剩下高四位
                int b=i&63;//&63就是只留下低6位
                if(a<12 && b<60){
                    if(b<10) res.add(a+":0"+b);
                    else res.add(a+":"+b);
                }
            }
        }
        return res;
    }
}
