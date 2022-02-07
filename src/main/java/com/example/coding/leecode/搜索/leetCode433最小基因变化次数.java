package com.example.coding.leecode.搜索;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 神様だよ
 * @Date 2022/1/9 10:32
 * @Version 1.0
 * @description:
 */
public class leetCode433最小基因变化次数 {
    public int minMutation(String start, String end, String[] bank) {
        HashMap<String,Integer> dist = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (String b : bank) {
            set.add(b) ;
        }
        Queue<String> q = new LinkedList<>();
        dist.put(start, 0) ;
        q.offer(start);
        char [] gene = {'A', 'C', 'G', 'T'};
        while (!q.isEmpty()) {
            String t = q.poll() ;
            if (t.equals(end)) {
                return dist.get(end) ;
            }
            char [] ch = t.toCharArray() ;
            for (int i = 0 ; i < ch.length; ++i) {
                char tmp = ch[i] ;
                for (char g : gene) {
                    if (ch[i] == g) continue ;
                    ch[i] = g;
                    String key = new String(ch);
                    if (!set.contains(key)) continue ;
                    if (!dist.containsKey(key)) {
                        dist.put(key, dist.get(t) + 1) ;
                        q.offer(key) ;
                    }
                }
                ch[i] = tmp ;
            }
        }
        return -1 ;
    }
}
