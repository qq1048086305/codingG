package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 10:03
 * @Version 1.0
 * @description:
 */
public class LeeCode482密钥格式化 {
    public String licenseKeyFormatting(String S, int K) {
        String s = "";
        //转成大写 并拿到不含‘-’的字符串
        for (char c : S.toCharArray()) {
            if (c != '-') {
                s += Character.toUpperCase(c);
            }
        }
        String res = "";
        //第一组放对k余数个字符
        res += s.substring(0, s.length() % K);
        //从余数位置开始拼接一次拼接k个即可
        for (int i = s.length() % K; i < s.length(); ) {
            if (res.length() > 0) {
                res += "-";
            }
            res += s.substring(i, i + K);
            i += K;
        }
        return res;
    }
}
