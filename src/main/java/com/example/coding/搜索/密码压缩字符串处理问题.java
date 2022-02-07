package com.example.coding.搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 19:18
 * @Version 1.0
 * @description:
 */
public class 密码压缩字符串处理问题 {
    static String ss;
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));

        ss=sc.readLine();
        System.out.print(dfs(0));
    }
    public static String dfs(int start){
        String s="";
        int n=0;
        while ((start+1<ss.length())){
            if(ss.charAt(start)=='['){
                int cur=start;
                while (ss.charAt(cur+1)>='0'&&ss.charAt(cur+1)<='9'){
                    n=n*10+ss.charAt(cur+1)-'0';
                    cur++;
                }
                String ans=dfs(cur+1);
                while (n-->0){
                    s+=ans;
                    res++;
                }
            }else{
                if (ss.charAt(start) == ']') {
                    return s;
                }else {
                    s+=ss.substring(start,start+1);
                }
            }
            start++;
        }
        return "";
    }
}
