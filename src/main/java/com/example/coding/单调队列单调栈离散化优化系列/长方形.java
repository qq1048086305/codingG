package com.example.coding.单调队列单调栈离散化优化系列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 10:34
 * @Version 1.0
 * @description:
 */
public class 长方形 {
    //单调栈优化
    static int MAXN = 1005;
    static int n,m,map[][]=new int[MAXN][MAXN],maxa[]=new int[MAXN],tmp[]=new int[MAXN],top = 0;
    //static int stack[]=new int[MAXN];
    public static void main(String[] args) throws IOException {
        String ss;
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String[] s = sc.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        for(int i = 1; i<=n; i++){
            ss=sc.readLine().trim();
            for(int j = 1; j<=m; j++)
            {
                map[i][j] = ss.charAt(j-1)=='*'?1:0;
            }
        }
        long ans = (long)n*(long)m*(long)(n+1)*(long)(m+1)/4;
        for(int i = 1; i<=n; i++)
        {
            Stack<Integer> stack=new Stack<>();
            Arrays.fill(tmp, 0);
            //stack.clear();
            top = 0;
            for(int j = 1; j<=m; j++)
            {
                if(map[i][j]==1) maxa[j] = i;
                while(!stack.isEmpty()&&maxa[stack.peek()]<=maxa[j]) stack.pop();
                if(stack.isEmpty()){
                    stack.push(0);
                }
                ans -= tmp[j] = tmp[stack.peek()]+maxa[j]*(j-stack.peek());
                stack.push(j);
            }
        }
        System.out.println(ans);
    }
}
