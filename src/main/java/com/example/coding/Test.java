package com.example.coding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 神様だよ
 * @Date 2021/11/25 10:06
 * @Version 1.0
 * @description:
 */
public class Test {
    public static int getMinDistance(int[] nums, int target, int start) {
        int l=0,r=nums.length-1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return Math.abs(start-l);
    }
    public static int myAtoi(String s) {

        String ss[]=s.split(" ");
        int ans=0;
        boolean flag=false;
        for(int i=0;i<ss.length;i++){
            if(ss[i].equals("")){
                continue;
            }else if( (ss[i].charAt(0)>='0'&&ss[i].charAt(0)<='9')||ss[i].charAt(0)=='-'&&!ss[i].contains("+")&&ss[i].length()!=1||ss[i].charAt(i)=='+'&&!ss[i].contains("-")){
                if(ss[i].charAt(0)=='+'){
                    ss[i]=ss[i].substring(1);
                    if(ss[i].length()==0){
                        return 0;
                    }
                }
                if(ss[i].contains(".")){
                    int index = ss[i].indexOf(".");
                    return Integer.parseInt(ss[i].substring(index-1,index));
                }
                if(ss[i].charAt(0)=='-'){
                    ss[i]=ss[i].substring(1);
                    flag=true;
                }
                long res=Long.parseLong(ss[i]);
                if(!flag&&res>Integer.MAX_VALUE){
                    res=Integer.MAX_VALUE;
                }else if(flag&&-res<Integer.MIN_VALUE){
                    res=Integer.MIN_VALUE;
                }
                ans= (int) res;
                break;
            }else{
                if(ans==0){
                    break;
                }
                continue;
            }
        }
        if(flag){
            return -ans;
        }else{
            return ans;
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q=new LinkedList<>();
        q.add(1);

    }
    static long fac(int i) // 然而这个函数不用讲什么
    {
        if (i == 1)
            return 1;
        else
            return i * fac(i - 1);
    }
}
