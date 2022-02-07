package com.example.coding.leecode.搜索;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 10:17
 * @Version 1.0
 * @description:
 */
public class LeeCode491递增子序列 {
    //位运算 哈希表 爆搜
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    HashSet<List<Integer>> set=new HashSet<>();
    void dfs(int nums[],int start){
        if(temp.size()>=2) set.add(new LinkedList<>(temp));

        for(int i=start;i<nums.length;i++){
            //队列用来保证单调递增
            if(!temp.isEmpty() && nums[i]<temp.peekLast()) continue;
            temp.addLast(nums[i]);
            dfs(nums,i+1);
            temp.pollLast();
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums,0);
        for(List<Integer> l:set) res.add(l);
        return res;
    }
}
