package com.example.coding.leecode.模拟;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 神様だよ
 * @Date 2022/1/22 13:02
 * @Version 1.0
 * @description:
 */
public class LeeCode525连续数组 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        int res = 0;
        for (int i = 1, cntOne = 0, cntZero = 0; i < n + 1; i++) {
            int x = nums[i - 1];
            if (x == 0) cntZero++;
            else cntOne++;
            int s = cntOne - cntZero;
            if (m.containsKey(s)) res = Math.max(res, i - m.get(s));
            else m.put(s, i);
        }
        return res;
    }

}
