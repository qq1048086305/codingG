package com.example.coding.单调队列单调栈离散化优化系列;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 12:24
 * @Version 1.0
 * @description:
 */
public class 单调对垒扫描 {
    static int N=1000005;
    static int n,k;
    static int a[]=new int[N];
    static LinkedList<Integer> que=new LinkedList<>(),qmax;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();
        PrintWriter out=new PrintWriter(System.out);
        for(int i=1;i<=n;i++){
            a[i]=sc.nextInt();
        }
        for (int i = 1; i <= n; i ++ )
        {   //判断队首是否不在当前窗口，如果是，删除队首(i-k就是左指针)
            while(!que.isEmpty()&&que.peek()<=i-k){//这边不能等于 因为这是加入之前的判断 = 的话相当于过滤了一个没有过期的元素
                que.pollFirst();
            }
            while(!que.isEmpty()&&a[i] >= a[que.peekLast()]){
                que.pollLast();
            }
            //res=Math.max(res,s[i]-s[que.peekFirst()]);
            que.addLast(i);//i-j>=0 i可以等于j先加入
            //到这里窗口形成了 这种方法我们给个默认值吧 0 是默认值不影响初始操作
            if(i>=k)out.println(a[que.peekFirst()]);
            //保持队列的递减性
            // res=Math.max(res,s[i]-s[que.peekFirst()]);
            //当前窗口已经形成，保存队首作为当前窗口最大值
            /*while (!que.isEmpty() && i - que[hh] > m) hh ++ ;
            res = Math.max(res, s[i] - s[que[hh]]);
            while (hh <= tt && s[que[tt]] >= s[i]) tt -- ;
            que[ ++ tt] = i;*/
        }
        out.flush();
    }

}
