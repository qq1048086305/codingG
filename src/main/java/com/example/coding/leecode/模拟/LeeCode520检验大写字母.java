package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/22 11:41
 * @Version 1.0
 * @description:
 */
public class LeeCode520检验大写字母 {
    public boolean detectCapitalUse(String word) {
        char[] ch = word.toCharArray();
        int cnt = 0;
        for (char c : ch)
            if (check(c))
                cnt++;

        return cnt == ch.length || cnt == 0 || (cnt == 1 && check(ch[0]));
    }

    private boolean check(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}
