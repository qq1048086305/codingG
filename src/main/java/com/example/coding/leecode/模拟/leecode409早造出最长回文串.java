package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/6 17:56
 * @Version 1.0
 * @description:
 */
public class leecode409早造出最长回文串 {
    public int longestPalindrome(String s) {
        int n = s.length();
        int [] map = new int [128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        int ret = 0 ;
        int odd = 0 ;
        for (int i = 0 ; i < 128 ; ++i) {
            if (map[i] % 2 == 0) {
                ret += map[i] ;
            } else {
                ret += map[i] - 1 ;
                odd++;
            }
        }
        return ret + (odd != 0 ? 1 : 0) ;

    }
}
