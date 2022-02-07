package com.example.coding.leecode.哈希表;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 神様だよ
 * @Date 2022/1/23 10:12
 * @Version 1.0
 * @description:
 */
public class LeeCode554砖墙 {
    //统计每个横坐标处缝隙数量放在哈希表李返回最多的
    public int leastBricks(List<List<Integer>> wall) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < wall.size(); i++) {
            //第几块砖头
            int preSum = 0;
            //横坐标
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                preSum += wall.get(i).get(j);
                //如果当前坐标存在缝隙 缝隙+1
                if (map.containsKey(preSum)) {
                    map.put(preSum, map.get(preSum) + 1);
                } else {
                    //否则新建一个横坐标
                    map.put(preSum, 1);
                }
            }
        }
        //找出答案
        for (Integer key : map.keySet()) {
            ans = Math.max(map.get(key), ans);
        }

        return wall.size() - ans;
    }
}
