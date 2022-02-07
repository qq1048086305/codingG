package com.example.coding.AOJ刷题;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author 神様だよ
 * @Date 2021/11/30 16:18
 * @Version 1.0
 * @description:
 */
public class JapanSinks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //岛的数量
        int n = sc.nextInt();
        //记录上一个岛的height
        //从0开始依次递增
        int prev = 0;
        //标记上升和下降
        boolean isDown = true;
        //按key排序的有序表 默认小到大
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            //当前遇到的岛比原来的大并且当前标记是下降的
            if (isDown && prev < x) {
                //当前有序表里面是否含有上一个prev元素 有的话加1
                if (map.containsKey(prev)) {
                    map.put(prev, map.get(prev) + 1);
                } else {//否则就是一个岛
                    map.put(prev, 1);
                }
                //现在是上升了
                isDown = false;
                //上升状态下遇到了一个小的元素
            } else if (!isDown && prev > x) {
                //减小小岛数量
                if (map.containsKey(prev)) {
                    map.put(prev, map.get(prev) - 1);
                } else {
                    map.put(prev, -1);
                }
                isDown = true;
            }
            //更新上一个值
            prev = x;
        }
        //结束后如果是isDown 那么将最后一个标记 减少1
        if (!isDown) {
            if (map.containsKey(prev)) {
                map.put(prev, map.get(prev) - 1);
            } else {
                map.put(prev, -1);
            }
        }
        //找到最大高度
        int max = 0;
        int current = 0;
        for (int x : map.values()) {
            current += x;
            max = Math.max(max, current);
        }
        System.out.println(max);
    }
}
