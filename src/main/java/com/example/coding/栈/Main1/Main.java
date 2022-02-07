package com.example.coding.栈.Main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 19:27
 * @Version 1.0
 * @description:
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s[]=sc.readLine().split(" ");
        Stack<Integer> stack=new Stack<>();
        int ans=1;
        for (int i = 0; i < s.length; i++) {
            char c=s[i].charAt(0);
            if(c>='1'&&c<='9'){
                stack.push(Integer.parseInt(s[i]));
            }else if(c=='*'){
               int a,b;
                   b=stack.pop();
                   a=stack.pop();
                   stack.push(a*b);
            }else if(c=='-'){
                int a,b;
                b=stack.pop();
                a=stack.pop();
                stack.push(a-b);
            }
            else if(c=='+'){
                int a,b;
                b=stack.pop();
                a=stack.pop();
                stack.push(a+b);
            }
        }
        System.out.println(stack.pop());
    }
}
