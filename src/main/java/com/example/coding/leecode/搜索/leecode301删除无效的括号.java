package com.example.coding.leecode.搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/12/23 8:35
 * @Version 1.0
 * @description:
 */
public class leecode301删除无效的括号 {
    //https://leetcode-cn.com/problems/remove-invalid-parentheses/submissions/
    /**
     * (搜索+剪枝)
     * 题解：首先我们要知道删除多少左括号和右括号，我们从左到右遍历一遍，如果遇到左括号，那么l ++代表当前未匹配的左括号，如果遇到右括号并且当前未匹配的左括号个数大于0，那么l --，说明当前右括号前面有与之匹配的左括号，如果未匹配的左括号个数等于0，说明当前这个括号是不合法的，r ++，最后l代表还没有匹配的左括号个数，也就是我们需要删除的个数。
     *
     * 接下来就是搜索+剪枝了。dfs函数参数分别为当前字符串、当前字符串已经遍历过的字符，当前字符串还需要删除多少个左括号和右括号。当不需要再删除括号的时候，判断当前字符串是否合法，如果合法就加入答案。
     *
     * 在扫描字符串时，如果遇到非括号字符直接跳过，遇到左右括号的时候如果还可以删除当前括号，那么就删除并递归求解。
     *
     * 剪枝策略1：多个连续相同的括号，我们只删除最左边的那个进行搜索，因为删除后序的括号得到的字符串也是一样的。
     *
     * 剪枝策略2:如果剩余字符数字已经小于还需要删除的字符个数，剪枝。（因为有非括号字符，所以还可以标记剩余的左括号和右括号个数是否小于当前要删除的个数，得到更早的剪枝）
     */
    static List<String> ans=new ArrayList<>();
    public static List<String> removeInvalidParentheses(String s) {
        ans.clear();
        int l=0,r=0;
        //先判断一共要删除多少个左和右括号
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                l++;
            }else
            if(l==0&&s.charAt(i)==')'){
                r++;
            }else if(s.charAt(i)==')'){
                l--;
            }
        }
        dfs(0,l,r,s);
        return ans;
    }
    public static void dfs(int u,int l,int r,String cur){
        if(l==0&&r==0){
            if(check(cur)){
                ans.add(cur);
            }
            return;
        }
        for(int i=u;i<cur.length();i++){
            if(cur.charAt(i)!='('&&cur.charAt(i)!=')'){
                continue;
            }
            //防止重复
            if( i == u || cur.charAt(i) != cur.charAt(i-1) ) {
                String temp=new String(cur);
                temp=removeCharAt(temp,i);
                if(cur.charAt(i)=='('&&l>0){
                    dfs(i,l-1,r,temp);
                }
                if(cur.charAt(i)==')'&&r>0){
                    dfs(i,l,r-1,temp);
                }
            }
        }
    }
    public static boolean check(String s){
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                cnt++;
            }else if(s.charAt(i)==')'){
                cnt--;
            }
            if(cnt<0){
                return false;
            }
        }
        return cnt==0;
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    public static void main(String[] args) {
        removeInvalidParentheses("(a)())()");
    }
}
