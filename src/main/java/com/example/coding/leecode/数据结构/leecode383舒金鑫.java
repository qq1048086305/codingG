package com.example.coding.leecode.数据结构;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 18:14
 * @Version 1.0
 * @description:
 */
public class leecode383舒金鑫 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int map[]=new int[101];
        for(char c:magazine.toCharArray()){
            map[c-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            char tmp=ransomNote.charAt(i);
            map[tmp-'a']--;
            if(map[tmp-'a']<0){
                return false;
            }
        }
        return true;
    }
}
