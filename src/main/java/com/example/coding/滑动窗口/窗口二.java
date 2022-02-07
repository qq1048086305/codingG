package com.example.coding.滑动窗口;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/9 12:14
 * @Version 1.0
 * @description:
 */
//利用双指针的思想从头到尾范围处理 p1指针从头开始 p2也是直接搞一遍然后消去p1原来在的位置的影响从第二个开始搞
public class 窗口二 {
    public static void main(String[] args) {
        //http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_3_A
        //http://judge.u-aizu.ac.jp/onlinejudge/review.jsp?rid=2692179#1 -- reference
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int K = in.nextInt();//target
            int a[] = new int[n+1];
            for(int i = 1; i<=n ;i++){
                a[i] = in.nextInt();
            }
            //标记数组
            int tag[] = new int[K+1];
            //use two pointer
            //本题a数组从1开始的否则p1初始值应该是0
            int p1 = 0, p2 = 0;
            int min = n+1;//smallest size
            int sum = 0;
            //moving the pointer and check the sum < k
            //先从头到尾找到最早符合要求的位置 然后缩小p1->p2的范围
            while(p1<=n){
                //p2 = p1;
                if(sum==K) {
                    min = Math.min(min, p2-p1);
                    //System.out.println(min);
                }
                //main body
                //move right pointer
                if(sum<K){//小于k挪右指针扩大范围
                    p2++;
                    if(p2>n) break;
                    if(a[p2] <= K){//sum统计满足k的数量 只记录第一次再次出现就++一下
                        if(tag[a[p2]]==0) sum++;
                        tag[a[p2]]++;
                    }
                }else {//否则缩小范围
                    p1++;
                    if(p1>n) break;
                    if(a[p1]<=K){
                        tag[a[p1]]--;
                        if(tag[a[p1]]==0) sum--;
                    }
                }

            }
            if(min == n+1) System.out.println(0);
            else System.out.println(min);

        }
}
