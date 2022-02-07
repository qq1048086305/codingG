package com.example.coding.leecode.图;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 神様だよ
 * @Date 2022/1/3 21:59
 * @Version 1.0
 * @description:
 */
public class leecode399除法求值 {
    //floyd算法
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[][] d = new double[50][50];
        Map<String,Integer> map = new HashMap<>();
        //从1开始
        int idx = 1;
        //统计节点个数
        for(List<String> list: equations){
            for(String t: list){
                //每个字符串（不管这个字符串是什么）唯一对应一个节点值
                if(!map.containsKey(t)) map.put(t, idx++);
            }
        }
        //初始化floyd数组
        for(int i = 1; i <= idx; i++){
            for(int j = 1; j <= idx; j++){
                if(i == j) d[i][j] = 1.0;
                // else d[i][j] = -1.0;
            }
        }
        for(int i = 0; i < equations.size(); i++){
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            //拿出 a 和 b
            int a = map.get(x), b = map.get(y);
            //a=>b的距离
            d[a][b] = values[i];
            //b=>a的距离
            d[b][a] = 1.0/values[i];
        }
        //从1开始
        for(int k = 1; k <= idx; k++){
            for(int i = 1; i <= idx; i++){
                for(int j = 1; j <= idx; j++){
                    if(d[i][k] != 0 && d[k][j] != 0){
                        d[i][j] = d[i][k] * d[k][j];
                    }
                }
            }
        }
        //搜下答案
        double[] res = new double[queries.size()];
        int k = 0;
        for(int i = 0; i < queries.size(); i++){
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if(!map.containsKey(x) || !map.containsKey(y)){
                res[k++] = -1.0;
                continue;
            }
            int a = map.get(x), b = map.get(y);
            res[k++] = d[a][b] == 0 ? -1 : d[a][b];
        }
        return res;
    }
}
