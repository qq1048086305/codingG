package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/9 10:37
 * @Version 1.0
 * @description:
 */
public class leetCode434字符单词个数 {
    public int countSegments(String s) {
        if(s.length()==0) return 0;
        s = s.trim();
        String[] t = s.split(" +");
        //判断多个空格的情况
        if(t.length == 1){
            if(t[0].length() == 0){
                return 0;
            }
        }
        return t.length;
    }
}
