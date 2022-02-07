package com.example.coding.leecode.字符串;

/**
 * @Author 神様だよ
 * @Date 2021/12/4 9:03
 * @Version 1.0
 * @description:
 */
public class leecode151带空格的字符串反转 {
    //https://leetcode.com/problems/reverse-words-in-a-string/submissions/
    //巧妙地用split分出空字符然后用 stringbuilder拼接
    public static String reverseWords(String s) {
        if (s == null) return s;
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String blank = "";
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (strArr[i].equals("")) continue;
            sb.append(blank);
            sb.append(strArr[i]);
            blank = " ";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  Bob    Loves  Alice   "));
    }
}
