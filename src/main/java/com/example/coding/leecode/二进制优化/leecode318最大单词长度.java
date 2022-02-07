package com.example.coding.leecode.二进制优化;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/12/24 8:48
 * @Version 1.0
 * @description:
 */
public class leecode318最大单词长度 {
    public int maxProduct(String[] words) {
        Arrays.sort(words,(s1, s2)->{
            return s2.length()-s1.length();
        });
        List<Integer> list=new ArrayList<>();
        for(String word:words){
            int s=0;
            for(int i=0;i<word.length();i++){
                s|=(1<<(word.charAt(i)-'a'));
            }
            list.add(s);
        }
        int res=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((list.get(i)&list.get(j))==0){
                    res=Math.max(res,words[i].length()*words[j].length());
                }
            }
        }
        return res;
    }
}
