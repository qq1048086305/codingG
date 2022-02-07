package com.example.coding.数论.全排列;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/25 11:03
 * @Version 1.0
 * @description:
 */
public class 情人节礼物 {
    static PrintWriter cout=new PrintWriter(System.out);//快速输出
    //a[i]记录上层的全排列 b[i]是当前 c[i]是原数组
    static int a[]=new int[11],b[]=new int[11],c[]=new int[11],n;
    //vis[]标记选过的元素 回溯用 每次从1-n遍历就行
    static boolean vis[]=new boolean[11];
    static boolean check1(int dep,int x)//判断同一个排列中是否出现了同一个数字
    {
        for(int i=1;i<dep;i++)
            if(b[i]==x)return false;
        return true;
    }
    static boolean check2()//判断是否查找到了目标排列
    {
        for(int i=1;i<=n;i++)
            if(b[i]!=c[i])return false;
        return true;
    }
    static void dfs(int dep)//搜索全排列模板
    {
        if(dep>n)
        {
            if(check2())
            {
                int flag=0;
                for(int i=1;i<=n;i++){
                    if(a[i]!=0)flag=1;
                }
                if(flag==0){
                    cout.println("ERROR");
                    cout.flush();
                    return;
                }
                else
                {
                    for(int i=1;i<=n;i++) {
                        cout.print((a[i])+" ");
                    }
                }
                cout.close();//关流
                return;
            }
            for(int i=1;i<=n;i++)a[i]=b[i];//copy
            return ;
        }
        for(int i=1;i<=n;i++)
        {
            if(!vis[i])//判重复
            {   vis[i]=true;
                b[dep]=i;
                dfs(dep+1);//搞下一个数
                vis[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for(int i=1;i<=n;i++){
            c[i]=sc.nextInt();
        }
        dfs(1);
    }

}
