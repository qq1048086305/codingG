package com.example.coding.leecode.哈希表;

import java.util.HashMap;

/**
 * @Author 神様だよ
 * @Date 2022/1/11 11:44
 * @Version 1.0
 * @description:
 */
public class LeetCode454四数相加2 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i < C.length;i ++)
            for(int j = 0;j < D.length;j ++)
            {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

        int res = 0;
        for(int i = 0;i < A.length;i ++)
            for(int j = 0;j < B.length;j ++)
            {
                int sum = A[i] + B[j];
                int val = sum * (-1);
                if(map.containsKey(val))
                    res += map.get(val);
            }

        return res;
    }
}
