package com.example.coding.leecode.数据结构;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 11:53
 * @Version 1.0
 * @description:
 */
public class LeeCode496下一个更大元素 {
    //哈希表加单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length ;
        HashMap<Integer,Integer> map = new HashMap<>();
        //哈希表存nums1中元素在nums2中对应位置
        for (int i = 0 ; i < n ; ++i) {
            int a = nums2[i] ;
            map.put(a, i) ;
        }
        int [] tmp = new int [n] ;
        //单调栈用来找 nums2中元素右边第一个比他大的数
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1 ; i >= 0 ; --i) {
            while (!stk.isEmpty() && nums2[i] >= stk.peek()) stk.pop();
            tmp[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(nums2[i]) ;
        }
        int m = nums1.length ;
        int [] ret = new int [m] ;
        for (int i = 0 ;i < m ; ++i) {
            ret[i] = tmp[map.get(nums1[i])] ;
        }
        return ret ;
    }
}
