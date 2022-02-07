package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author 神様だよ
 * @Date 2021/12/11 16:01
 * @Version 1.0
 * @description:
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
    public static boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                st.add(s.charAt(i));
            }else{
                if(st.isEmpty()){
                    return false;
                }else{
                    if(st.peek()=='('&&s.charAt(i)==')'){
                        st.pop();
                        continue;
                    }
                    if(st.peek()=='['&&s.charAt(i)==']'){
                        st.pop();
                        continue;
                    }
                    if(st.peek()=='{'&&s.charAt(i)=='}'){
                        st.pop();
                        continue;
                    }else{
                        return false;
                    }
                }
            }

        }
        return true;
    }
}
