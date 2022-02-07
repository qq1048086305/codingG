package com.example.coding.leecode.双指针;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/10 16:31
 * @Version 1.0
 * @description:
 */
public class leetCode438找到字符串中的所有异位词起始下标 {
    public List<Integer> findAnagrams(String s, String p) {
        //哈希表记录B字符串中每个字符出现的次数
        int[] hash = new int[26];
        for(char c: p.toCharArray()){
            hash[c-'a']++;
        }
        //统计B字符种数
        int target = 0;
        for(int i = 0; i < 26; i++){
            if(hash[i] != 0) target++;
        }

        int cnt = 0;
        List<Integer> res = new ArrayList<>();
        char[] ss = s.toCharArray();
        //双指针维护一个窗口
        for(int i = 0, j = 0; i < ss.length; i++){
            //当前这个字符的位置正好减少到0（凑出了p字符串中的一个字母） cnt++
            if(--hash[ss[i]-'a'] == 0) cnt++;
            if(i-j+1 > p.length()){
                if(hash[ss[j]-'a'] == 0) cnt--;
                hash[ss[j++]-'a']++;
            }
            //有满足要求的答案
            if(cnt == target) res.add(j);
        }
        return res;
    }
}

