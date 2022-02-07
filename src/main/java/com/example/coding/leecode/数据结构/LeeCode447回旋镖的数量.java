package com.example.coding.leecode.数据结构;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 神様だよ
 * @Date 2022/1/10 17:50
 * @Version 1.0
 * @description:
 */
public class LeeCode447回旋镖的数量 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        //一共n个点
        int n = points.length;
        for (int i = 0; i < n; i++) {
            //哈希表统计数量
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                //ij不在同一个点上
                if (i != j) {
                    //计算距离
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    //距离加到表里
                    cnt.put(dx * dx + dy * dy, cnt.getOrDefault(dx * dx + dy * dy, 0) + 1);
                }
            }
            //遍历哈希表统计答案
            for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
                res += e.getValue() * (e.getValue() - 1);
            }
        }
        return res;
    }
}
