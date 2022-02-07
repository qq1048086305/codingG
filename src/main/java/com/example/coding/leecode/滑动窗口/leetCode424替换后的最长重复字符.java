package com.example.coding.leecode.滑动窗口;

/**
 * @Author 神様だよ
 * @Date 2022/1/9 10:20
 * @Version 1.0
 * @description:
 */
public class leetCode424替换后的最长重复字符 {
    /*
        维持一个[j, i]的窗口，使得整个窗口内部在k次变化内都能变成同一个字母

        满足要求的窗口：
            窗口的长度 - 窗口内最多字符的数量 <= k (就能在k次改变内变成同一个字符)

        在所有满足要求的窗口中，取一个窗口长度的最大值就是结果
*/
    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int[] window = new int[26]; //统计窗口内的每种字符的数量
        int maxSameNum = 0; //窗口内相同字符最多的数量
        int res = 0;
        for (int i = 0, j = 0; i < cs.length; i++) {
            window[cs[i]-'A']++;
            maxSameNum = Math.max(window[cs[i]-'A'], maxSameNum);
            int windowLength = i-j+1;
            //当窗口的长度 - maxSameNum > k：无法在k次变化使整个窗口变为全部相同的字母
            while (j <= i && windowLength-maxSameNum > k) {
                window[cs[j]-'A']--;
                j++;
                windowLength = i-j+1;
            }
            res = Math.max(res, windowLength); //在满足要求的窗口，取一个最大值
        }
        return res;
    }
}
