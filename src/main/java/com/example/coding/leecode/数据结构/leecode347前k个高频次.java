package com.example.coding.leecode.数据结构;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author 神様だよ
 * @Date 2021/12/28 12:22
 * @Version 1.0
 * @description:
 */
public class leecode347前k个高频次 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>(); // <num, time>
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (o1, o2) -> freq.get(o1) - freq.get(o2)); // 小根堆，比较的是元素的词频
        // 将哈希表中的元素加入到小根堆中
        freq.forEach(
                (num, times) -> {
                    heap.offer(num);
                    // 维持小根堆大小为 k
                    if (heap.size() > k) heap.poll();
                });
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) ret[i] = heap.poll();
        return ret;
    }
}
