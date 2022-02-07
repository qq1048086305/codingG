package com.example.coding.leecode.搜索;

import java.util.HashMap;

/**
 * @Author 神様だよ
 * @Date 2022/1/2 21:13
 * @Version 1.0
 * @description:
 */
public class leecode397整数替换 {
    HashMap<Integer,Integer> dp=new HashMap<>();
    public int integerReplacement(int n) {
        dp.clear();
        return  dfs(n);
    }
    public int dfs(int cur){
        if(cur==1){
            return 0;
        }
        if(dp.containsKey(cur)){
            return dp.get(cur);
        }
        int ans = cur%2==0?dfs(cur/2):Math.min(dfs(cur+1),dfs(cur-1));
        ans++;
        dp.put(cur,ans);
        return ans;
    }

    public static void main(String[] args) {
        leecode397整数替换 leecode397整数替换=new leecode397整数替换();
        leecode397整数替换.integerReplacement(8);
    }
}
