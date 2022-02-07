package com.example.coding.leecode.数据结构;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author 神様だよ
 * @Date 2022/1/1 21:15
 * @Version 1.0
 * @description:
 */
public class leecode373查找和最小的两个对 {
    class Node{
        int fir,sec;
        public Node(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }

    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<Node> h = new PriorityQueue<>((o1, o2) -> {
                return (o2.fir + o2.sec ) - (o1.fir + o1.sec);
            });

            // 最小的k个数必然存在于nums1和nums2的前k个数中
            for(int i = 0; i < Math.min(k, nums1.length); i++) {
                for(int j = 0; j < Math.min(k, nums2.length); j++) {
                    h.add(new Node(nums1[i], nums2[j]));
                    if (h.size() > k) {
                        h.poll();
                    }
                }
            }

            List<List<Integer>> res = new LinkedList<>();
            for(Node n : h) {
                List<Integer> l = new LinkedList<>();
                l.add(n.fir);
                l.add(n.sec);
                res.add(l);
            }

            return res;
        }
    }
}
