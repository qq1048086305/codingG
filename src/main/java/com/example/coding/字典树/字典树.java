package com.example.coding.字典树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 23:12
 * @Version 1.0
 * @description:
 */
public class 字典树 {
    static int idx=0;// 将该字符串分配的一个树结构中，以下标来记录每一个字符的位置。方便之后的插入和查找。
    static int N=1000005;
    static int son[][]=new int[N][26];;// 其中存放的是：子节点对应的idx。其中son数组的第一维是：父节点对应的idx，第第二维计数是：其直接子节点('a' - '0')的值为二维下标。
    static int cnt[]=new int[N];// 以“abc”字符串为例，最后一个字符---‘c’对应的idx作为cnt数组的下标。数组的值是该idx对应的个数。
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sc.readLine().trim()) ;
        while (n-->0){
            String s[]=sc.readLine().split(" ");
            String ss=s[0];
            String sss=s[1];
            if(ss.equals("insert")){
                insert(sss);
            }else{
                if(find(sss)){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }
        }
    }
    public static void insert(String s){
        char[] str=s.toCharArray();
        int p = 0;
        for (int i = 0; i<str.length; i++)
        {
            int u = str[i] - 'A';
            if (son[p][u]==0) son[p][u] = ++idx;
            p = son[p][u];
        }
        // 此时的p就是str中最后一个字符对应的trie树的位置下标。
        cnt[p]++;
    }
    public static boolean find(String s){
        char[] str=s.toCharArray();
        int p = 0;
        for (int i = 0; i<str.length; i++)
        {
            int u = str[i] - 'A';
            if (son[p][u]==0) return false;
            p = son[p][u];
        }
        return cnt[p]==0?false:true;
    }
}
