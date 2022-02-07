package com.example.coding.leecode.搜索;

import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/12/2 8:13
 * @Version 1.0
 * @description:
 */
public class leecode22生成所有可行括号 {
    //https://leetcode.com/problems/generate-parentheses/description/
    //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    //直接生成合法的序列一定满足右括号的个数总是小于等于左括号的个数，是一个典型的卡特兰数问题，卡特兰数的时间复杂度是O(Cn2nn+1)
    //https://leetcode.com/problems/generate-parentheses/submissions/

     //https://leetcode.com/problems/matchsticks-to-square/submissions/

    //这个代码TLE了
    static int ans;
    static boolean st[];
    static boolean flag=false;
    public boolean makesquare(int[] matchsticks) {
        flag=false;
        int sum=0;
        int n=matchsticks.length;
        st=new boolean[n+1];
        for(int i=0;i<matchsticks.length;i++){
            sum+=matchsticks[i];
        }
        ans=sum/4;
        if(ans*4!=sum){
            return false;
        }else{
            Arrays.sort(matchsticks);
            return dfs(0,matchsticks,0);
        }

    }
    public boolean dfs(int cnt,int[] nums,int sum){
        if(flag){
            return flag;
        }
        if(sum>ans){
            return false;
        }
        if(cnt==3){
            flag=true;
            return true;
        }
        if(sum==ans){
            dfs(cnt+1,nums,0);
        }
        for(int i=nums.length-1;i>=0;i--){
            //可行性剪枝
            if(flag){
                return true;
            }
            if(!st[i]){
                st[i]=true;
                dfs(cnt,nums,sum+nums[i]);
                st[i]=false;
            }
        }
        return flag;

    }
}
