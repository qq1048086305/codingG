package com.example.coding.leecode.模拟;

import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/22 12:49
 * @Version 1.0
 * @description:
 */
public class Leecode524通过删除字母 {
    public String findLongestWord(String s, List<String> d) {
        String res = "";
        for (String w : d) {
            if ((w.length() > res.length() ||
                    (w.length() == res.length() && res.compareTo(w) > 0))
                    && check(w, s)) {
                res = w;
            }
        }
        return res;
    }
    //判断当前串子序列是否含有s
    private boolean check(String w, String s) {
        int i = 0, j = 0;
        while(i < w.length() && j < s.length()) {
            if (w.charAt(i) == s.charAt(j)) {
                i ++;
            }
            j ++;
        }
        return i == w.length();
    }

}
