package com.example.coding.数论.组合数学;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/16 17:11
 * @Version 1.0
 * @description:
 */
public class 编码 {
    String s;
    static int ans,n;
    static int c(int m,int n)//组合数计算
    {
        if(m==0)return 1;
        int mut=1;
        for(int i=n;i>n-m;i--)mut*=i;
        for(int i=m;i>1;i--)mut/=i;
        return mut;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String s=sc.readLine();
        n=s.length();
        for(int i=1;i<n;i++)
            if(s.charAt(i)<=s.charAt(i-1)) {System.out.println(0);return;}//判断是否存在
        for(int i=1;i<n;i++)ans+=c(i,26);//计算出位数比它小的单词数
        for(int i=0;i<n;i++)//枚举每一位
            for(char j=(char)(i==0?'a':((s.charAt(i-1))+1));j<s.charAt(i);j++)//注意考虑边界
                ans+=c(n-i-1,'z'-j);//因为字符串下标从0开始，所以是n-i-1而不是n-i
        System.out.println(++ans);//别忘了最后把自己加上
    }
}
