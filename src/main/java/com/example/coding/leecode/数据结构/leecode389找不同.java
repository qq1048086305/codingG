package com.example.coding.leecode.数据结构;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 18:51
 * @Version 1.0
 * @description:
 */
public class leecode389找不同 {
    //https://leetcode-cn.com/problems/find-the-difference/submissions/
    public char findTheDifference(String s, String t) {
        if(s.length()==0){
            return t.charAt(0);
        }
        int map[]=new int[100];
        for(int i=0;i<t.length();i++){
            map[t.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-'a']--;
        }
        for(int i=0;i<t.length();i++){
            if(map[t.charAt(i)-'a']>0){
                return t.charAt(i);
            }
        }
        return '5';
    }
}
