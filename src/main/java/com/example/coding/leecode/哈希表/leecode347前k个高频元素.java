package com.example.coding.leecode.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leecode347前k个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>(); // <num, times>
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        int n = nums.length;
        // 把数都放到桶中（桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i）
        List<Integer>[] buckets = new ArrayList[n + 1];
        freq.forEach(
                (num, times) -> {
                    if (buckets[times] == null) buckets[times] = new ArrayList<>();
                    buckets[times].add(num);
                });
        // 从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数
        int[] ret = new int[k];
        for (int i = n, idx = 0; i >= 0 && idx < k; i--) {
            if (buckets[i] == null) continue;
            for (int num : buckets[i]) {
                ret[idx++] = num;
                if (idx == k) break;
            }
        }
        return ret;
    }
}
