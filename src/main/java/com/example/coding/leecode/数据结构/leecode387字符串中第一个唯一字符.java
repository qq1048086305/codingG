package com.example.coding.leecode.数据结构;

import java.util.HashMap;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 18:30
 * @Version 1.0
 * @description:
 */
public class leecode387字符串中第一个唯一字符 {
    public int firstUniqChar(String s) {
        char []str=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length;i++){
            map.put(str[i],map.getOrDefault(str[i],0)+1);
        }
        for(int i=0;i<str.length;i++){
            if(map.get(str[i])==1){
                return i;
            }
        }
        return -1  ;
    }
}
