package com.example.coding.leecode.数据结构.滑动窗口;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 20:03
 * @Version 1.0
 * @description:
 */
public class leecode395至少有k个重复字符的最长子串 {
    //滑动窗口维护的是一段子串，要求是最多包含i个字符
    //如果在滑动窗口中每一字符出现次数都不少于k。那么该长度是一个解
    //不断扩大i，因为i扩大且保证每个字符出现次数不小于k，这个子串自然就越长
    public int longestSubstring(String s, int k) {
        int res=0;
        for(int i=1;i<=26;i++){
            int arr[]=new int[26];
            int l=0,r=0,cnt=0,overK=0;
            while(r<s.length()){
                arr[s.charAt(r)-'a']++;
                if(arr[s.charAt(r)-'a']==1) cnt++;//元素个数
                if(arr[s.charAt(r)-'a']==k) overK++;//大于等于k的元素个数
                r++;

                while(l<r && cnt>i){
                    if(arr[s.charAt(l)-'a']==1) cnt--;
                    if(arr[s.charAt(l)-'a']==k) overK--;
                    arr[s.charAt(l)-'a']--;
                    l++;
                }

                if(overK==i) res=Math.max(res,r-l);
            }
        }
        return res;
    }
}
