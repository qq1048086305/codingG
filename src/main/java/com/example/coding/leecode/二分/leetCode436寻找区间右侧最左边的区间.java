package com.example.coding.leecode.二分;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 神様だよ
 * @Date 2022/1/10 16:24
 * @Version 1.0
 * @description:
 */
public class leetCode436寻找区间右侧最左边的区间 {
    public int[] findRightInterval(int[][] range) {
        int n = range.length;
        Map<Integer,Integer> map = new HashMap<>();
        //将区间左端点加入哈希表
        for(int i = 0; i < n; i++){
            map.put(range[i][0], i);
        }
        //按区间左端点从小到大排序
        Arrays.sort(range, (o1, o2) -> o1[0]-o2[0]);
        //定义一个结果数组
        int[] res = new int[n];
        //没有答案结果为-1
        Arrays.fill(res, -1);
        //从左到右 以每一个端点为目标二分出答案
        for(int i = 0; i < n; i++){
            int l = 0, r = n-1;
            while(l < r){
                int mid = l + r >> 1;
                if(range[mid][0] >= range[i][1]) r = mid;
                else l = mid+1;
            }
            //满足二分结果的左端点大于当前区间右端点符合要求 加入答案
            if(range[l][0] >= range[i][1]) res[map.get(range[i][0])] = map.get(range[l][0]);
        }
        return res;
    }
}
