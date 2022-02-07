package com.example.coding.leecode.线段树扫描线;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 18:56
 * @Version 1.0
 * @description:
 */
public class leecode391完美矩形 {
    /**
     * https://leetcode-cn.com/problems/perfect-rectangle/solution/gong-shui-san-xie-chang-gui-sao-miao-xia-p4q4/
     * @param rectangles
     * @return
     */
    public boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        int[][] rs = new int[n*2][4];
        for (int i = 0, idx = 0; i < n; i++) {
            int[] rect = rectangles[i];
            //扫描线算法都是找到切割后小矩形的 {x1, y1, y2} 和 {x2, y1, y2}
            rs[idx++] = new int[]{rect[0], rect[1], rect[3], 1};
            rs[idx++] = new int[]{rect[2], rect[1], rect[3], -1};
        }

        //扫描线算法都要排序,按照x排序，x相等时，按照y1进行排序
        Arrays.sort(rs, (o1, o2) -> {
            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
        });

        for (int i = 0; i < 2*n;) {
            int j = i+1;
            //[i..j)都是 x相等的
            while(j < 2*n && rs[j][0] == rs[i][0]) j++;
            List<int[]> l1 = new ArrayList<>();
            List<int[]> l2 = new ArrayList<>();
            for (int k = i; k < j; k++) {
                //把矩形左侧线和右侧线区分开
                List<int[]> l = rs[k][3] == 1 ? l1 : l2;
                if(l.isEmpty()){
                    //加入一段线
                    l.add(new int[]{rs[k][1], rs[k][2]});
                }else{
                    int[] line = l.get(l.size()-1);
                    //由于按照y1排序，所以新加入的线段y1 >= 已存在线段的y1
                    if(line[1] > rs[k][1]){
                        //线段重合
                        return false;
                    }else if(line[1] == rs[k][1]){
                        //线段合并
                        l.get(l.size()-1)[1] = rs[k][2];
                    }else{
                        //添加线段
                        l.add(new int[]{rs[k][1], rs[k][2]});
                    }
                }
            }

            if(i == 0 || j == 2*n){
                if(l1.size() + l2.size() != 1){
                    return false;
                }
            }else{
                if(l1.size() != l2.size()){
                    return false;
                }
                for (int k = 0; k < l1.size(); k++) {
                    if(l1.get(k)[0] != l2.get(k)[0] || l1.get(k)[1] != l2.get(k)[1]){
                        return false;
                    }
                }
            }
            i = j;
        }
        return true;
    }
}
