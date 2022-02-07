package com.example.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/6 14:19
 * @Version 1.0
 * @description:
 */
public class KMP {
    //原理 不包括自身的最大前后缀长度 如果皮配不上就跳到字符串当前最大长度位置（比如ababa 从第四个字符跳到第三个字符去找）
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String t=sc.readLine();
        String s=sc.readLine();
        int m=s.length();
        char [] str=new char[s.length()+1];
        for(int i=0;i<s.length();i++){
            str[i+1]=s.charAt(i);
        }
        int next[]=new int[s.length()+1];
        for (int i = 2, j = 0; i <= m; ++ i)
        {
            while (j>0 && s.charAt(i-1) != s.charAt(j)){
                j = next[j];
           }
            if (s.charAt(i-1) == s.charAt(j)) ++ j;
            next[i] = j;
        }

        StringBuilder sb = new StringBuilder();
        //begin search
        int j = 0;
        int i = 0;
        int c = 0;
        int mat = 0;
//		System.out.println("START");
        while(i < t.length())
        {
//			System.out.println(i + " " + j);
            if(t.charAt(i) ==s.charAt(j))
            {
                if(j == s.length()-1)
                { //whole pattern matched
                    //MATCH!
                    {
//						System.out.println("Match at " + (i-s.length()+1) + "~" + (i));
                        sb.append((i-s.length()+1));
                        sb.append('\n');
                    }
                    if(j > 0) //do the same as if mismatched, so that overlapped matches will all be found
                        j = next[j];
                    else
                    {
                        j = 0;
                        i++;
                    }
                }
                else
                { //letter matched: go to next letter
                    i++;
                    j++;
                }
            }
            else
            { //mismatch
                if(j > 0)
                    j = next[j];
                else
                {
                    j = 0;
                    i++;
                }
            }

        }

        System.out.print(sb);
    }
}
