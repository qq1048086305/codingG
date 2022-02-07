package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/23 10:24
 * @Version 1.0
 * @description:
 */
public class LeeCode557反转字符串3 {
    public void swap(char arr[],int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public String reverse(String s){
        char arr[]=s.toCharArray();
        for(int i=0;i<s.length()/2;i++)
            swap(arr,i,s.length()-1-i);
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<arr.length;i++) sb.append(arr[i]);
        return sb.toString();
    }
    public String reverseWords(String s) {
        if(s==null) return null;
        String arr[]=s.split(" ");
        for(int i=0;i<arr.length;i++)
            arr[i]=reverse(arr[i]);
        StringBuffer res=new StringBuffer();
        for(int i=0;i<arr.length;i++){
            res.append(arr[i]);
            if(i!=arr.length-1) res.append(" ");
        }
        return res.toString();
    }
}
