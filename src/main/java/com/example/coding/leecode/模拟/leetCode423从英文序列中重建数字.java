package com.example.coding.leecode.模拟;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/9 10:01
 * @Version 1.0
 * @description:
 */
public class leetCode423从英文序列中重建数字 {
    //模拟一遍
    public String originalDigits(String s) {
        //有序的处理数字
        String[] strs = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        //String[] strs1 = new String[]{"", "one", "", "", "", "", "", "", "", "nine"};
        //与strs一一对应
        int[] nums = new int[]{0, 8, 2, 4, 6, 3, 5, 7, 1, 9};
        //存储26个英文字母每个字母个数的数组
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        //结果数组
        List<Integer> res = new ArrayList<>();
        //从0开始减少cnt数组里面数的个数
        for (int i : nums) {
            boolean flag = true;
            while (flag) {
                //判断是否至少能凑出一个单词
                for (char c : strs[i].toCharArray()) {
                    if (cnt[c - 'a'] <= 0) {
                        flag = false;
                        break;
                    }
                }
                //减少一个当前的档次
                if (flag) {
                    res.add(i);
                    for (char c : strs[i].toCharArray()) {
                        cnt[c - 'a']--;
                    }
                }
            }
        }
        //对res从小到大拍一下旭
        Collections.sort(res);
        String ans = "";
        //拼成字符串
        for (int i : res) {
            ans += i;
        }
        return ans;
    }

}
