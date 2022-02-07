package com.example.coding.AOJ刷题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/12/6 14:22
 * @Version 1.0
 * @description:
 */
public class AOJ1085 {
    /**
     * 选择一个配对魔法使 大于一个值的对数
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s[]=sc.readLine().split(" ");
            int n=Integer.parseInt(s[0]);
            int S=Integer.parseInt(s[1]);
            if(n==0&&S==0){
                return;
            }
            int l=1;
            int r=n;//双指针法统计答案
            int a[]=new int[n+1];
            int ans=0;
            for(int i=1;i<=n;i++){
                a[i]=Integer.parseInt(sc.readLine().trim());
            }
            //从小到大排个序按魔力值
            Arrays.sort(a,1,n+1);
            while (l<r){
                if(a[l]+a[r]>S){
                    //当前序列有序如果l+r大于了s那么比l大的和r组合都是答案
                    ans+=r-l;
                    //右侧指针左移
                    r--;
                }else {//如果l+r<=s那么左侧不够大左指针向右移
                    l++;
                }
            }
            System.out.println(ans);
        }
    }
}
