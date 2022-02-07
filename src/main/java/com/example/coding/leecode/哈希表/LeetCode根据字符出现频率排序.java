package com.example.coding.leecode.哈希表;

import java.util.*;

/**
 * @Author 神様だよ
 * @Date 2022/1/11 11:13
 * @Version 1.0
 * @description:
 */
public class LeetCode根据字符出现频率排序 {
    public String frequencySort(String s) {
        //统计出现次数
        TreeMap<Character,Integer> tm = new TreeMap<>();
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if (tm.containsKey(c)){
                tm.put(c,tm.get(c)+1);
            }else {
                tm.put(c,1);
            }
        }
        //list里面存放键值对    map.entrySet获取所有键值对
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(tm.entrySet());
        //按照出现次数排序
        Collections.sort(list, (o1, o2) -> o2.getValue()-o1.getValue());
        StringBuilder sb = new StringBuilder();
        //拼接答案
        for (Map.Entry<Character,Integer> e:list){
            for (int i = 0;i<e.getValue();i++){
                //拼接value次当前元素
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

}
