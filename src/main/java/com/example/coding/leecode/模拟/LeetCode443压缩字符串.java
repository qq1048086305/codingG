package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/10 16:57
 * @Version 1.0
 * @description:
 */
public class LeetCode443压缩字符串 {
    public int compress(char[] chars) {
        //计数器
        int k = 0;
        //从头到尾遍历一遍使用双指针的思路
        for (int i = 0; i < chars.length; i++) {
            //右指针  到达当前字符重复的字符最右端的位置
            int j = i + 1;
            while (j < chars.length && chars[j] == chars[i]) j++;
            //重复字符的数量
            int len = j - i;
            chars[k++] = chars[i];
            //字符数量大于1拼接到后面
            if (len > 1) {
                char[] ch = String.valueOf(len).toCharArray();
                for (int t = 0; t < ch.length; t++) chars[k++] = ch[t];
            }
            //保证i从下一个不重复字符位置开始
            i = j - 1;
        }

        return k;
    }
}
