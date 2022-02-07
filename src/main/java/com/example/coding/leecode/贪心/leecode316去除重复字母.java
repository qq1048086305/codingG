package com.example.coding.leecode.贪心;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 神様だよ
 * @Date 2021/12/24 8:20
 * @Version 1.0
 * @description:
 */
public class leecode316去除重复字母 {
    //https://leetcode-cn.com/problems/remove-duplicate-letters/submissions/
    //https://leetcode-cn.com/problems/remove-duplicate-letters/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-4/
    public String removeDuplicateLetters(String s) {
        // acw, 贪心做法，遍历，若当前字符比上一个字符小，且上一个字符可以被删掉（上个字符在后面也出现过），则用当前字符替换掉上一个字符。
        String res = "";
        Map<Character, Boolean> inRes = new HashMap<>(); // 存储字符是否在结果中出现
        Map<Character, Integer> last = new HashMap<>(); // 存储原串中字符最后一次出现的位置
        for (int i = 0; i < s.length(); i++) last.put(s.charAt(i), i);

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (inRes.containsKey(cur) && inRes.get(cur)) continue; // 若字符在结果中已经出现过，则跳过

            // 若当前字符比上一个字符小，且结果中字符在后面出现过。则循环处理将比当前字符大的字符都替换掉
            while (res.length() > 0 && cur < res.charAt(res.length() - 1)  && last.get(res.charAt(res.length() - 1)) > i  ) {
                inRes.put(res.charAt(res.length() - 1), false);
                res = res.substring(0, res.length() - 1);
            }

            res = res + cur;
            inRes.put(cur, true);
        }

        return res;
    }
}
