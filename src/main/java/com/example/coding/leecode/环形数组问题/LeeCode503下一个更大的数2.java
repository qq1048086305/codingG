package com.example.coding.leecode.环形数组问题;

import java.util.LinkedList;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 12:13
 * @Version 1.0
 * @description:
 */
public class LeeCode503下一个更大的数2 {
    //环成链 单调栈
    public int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        int t[]=new int[len*2];
        for(int i=0;i<len;i++) t[i]=t[len+i]=nums[i];
        //[1,2,1,1,2,1]
        LinkedList<Integer> stack=new LinkedList<>();
        int res[]=new int[len];
        for(int i=2*len-1;i>=0;i--){
            while(!stack.isEmpty() && t[stack.peekLast()]<=t[i])
                stack.pollLast();
            if(i>=len) stack.addLast(i);
            else{
                res[i]=stack.isEmpty()?-1:t[stack.peekLast()];
                stack.addLast(i);
            }
        }

        return res;
    }
}
