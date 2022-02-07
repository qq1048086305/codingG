package com.example.coding.leecode.字符串;

import java.util.ArrayList;

/**
 * @Author 神様だよ
 * @Date 2021/12/11 10:05
 * @Version 1.0
 * @description:
 */
public class leecode14最长公共前缀 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null||strs[0].equals("")){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        //找一个就行
        char map[]=new char[strs[0].length()];
        for(int i=0;i<map.length;i++){
            map[i]=strs[0].charAt(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<strs.length;i++){
            int res=0;
            for(int j=0;j<strs[i].length()&&j<map.length;j++){
                if(strs[i].charAt(j)==map[j]){
                    res++;
                }else{
                    break;
                }
            }
            ans=Math.min(ans,res);
        }
        new ArrayList<>();
        String ss="";
        for(int i=0;i<ans;i++ ){
            ss+=map[i];
        }
        return ss;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"cir","car"}));
    }
}
