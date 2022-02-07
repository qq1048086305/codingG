package com.example.coding.数组型线段树;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 18:50
 * @Version 1.0
 * @description:
 */
public class 降雨量 {
    static int maxn =(int) 2e5+9;
    static int t[]=new int[maxn],n,m;  //t 记录区间最大值
    static int year[]=new int[maxn],rain[]=new int[maxn];
    static int mid(int x,int y){
        return (x+y)>>1;
    }
    static int ls(int x){
        return x<<1;
    }
    static int rs(int x){
        return x<<1|1;
    }
    static void update(int now,int l,int r,int pos,int value){
        if(l == r) {t[now] = value;return;}
        int mid=(l+r)>>1;
        if(pos <= mid) update(ls(now),l,mid,pos,value);
        else update(rs(now),mid+1,r,pos,value);
        t[now] = Math.max(t[ls(now)],t[rs(now)]);  //维护区间最大值
    }

    static int query(int now,int l,int r,int x,int y){  //询问x到y区间最大值
        if(x <= l&&r <= y) return t[now];
        int an = 0;
        int mid=(l+r)>>1;
        if(x <= mid) an = query(ls(now),l,mid,x,y);
        if(y > mid) an = Math.max(an,query(rs(now),mid+1,r,x,y));
        return an;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(sc.readLine());
        String s[];
        int y,r;
        for(int i=1;i<=n;i++)  {
            s=sc.readLine().split("\\s+");
            y=Integer.parseInt(s[0]);
            r=Integer.parseInt(s[1]);
            year[i] = y;
            rain[i] = r;
            update(1,1,n,i,r);
        }
        m=Integer.parseInt(sc.readLine());
        int Y,X,p1,p2,f1,f2; //p1 p2是在数组的位置,f1 f2两个标记记录X Y是否已知降水量
        for(int i=1;i<=m;i++){
            s=sc.readLine().split("\\s+");
            Y=Integer.parseInt(s[0]);
            X=Integer.parseInt(s[1]);
            p1 = low_bound(1,1+n, Y) ; //year在输入时保证是有序的
            p2 = low_bound(1,1+n, X) ;
            f1 = (p1 == n + 1|| year[p1] != Y) ? 0 : 1;
            f2 = (p2 == n + 1 ||year[p2] != X) ? 0 : 1;
            //两年都不知道,可以不管中间如何，都是未知的
            if(f1==0 && f2==0) {System.out.println("maybe");
                continue;}
            //两年都知道
            if(f1!=0 && f2!=0) {
                if(rain[p1] < rain[p2]) {
                    System.out.println("false");
                    continue;
                }        //X年降水量多于Y年，错
                if(Y + 1 == X ) {
                    System.out.println("true");
                    continue;
                }                 //X = Y+1年，中间没有其他年份，而X年降水量一定不大于Y，对
                if(p1 + 1 == p2) {System.out.println("maybe");
                    continue;}               //X不是Y后一年,但是X和Y年间都不知道降雨量，未知
                int maxGap = query(1,1,n,p1+1,p2-1);   //X和Y间存在已知降水量的年份，在其中找到降雨量最大值
                if(maxGap >= rain[p2]) {
                    System.out.println("false");
                    continue;
                }         //大于等于都满足严格小于，错
                if(p2 - p1 == X - Y) {
                    System.out.println("true");
                    continue;
                }            //满足严格小于后再判断X和Y间每年降雨量是否都已知
                else {
                    System.out.println("maybe");
                    continue;
                    //不是都已知，即未知
                }
            }
            //后一年不知道，p2 一定大于 p1,只可能是maybe或者false
            else if(f1!=0){
                if( p1 + 1 == p2 ) {
                    System.out.println("maybe");
                    continue;
                }
                int maxGap = query(1,1,n,p1+1,p2-1);   //注意查询范围
                if(maxGap >= rain[p1]) {
                    System.out.println("false");
                    continue;
                }
                else {
                    System.out.println("maybe");
                    continue;
                }
            }
            //前一年不知道，p1 有可能等于 p2,只可能是maybe或者false
            else{
                if(p1  == p2 ) {
                    System.out.println("maybe");
                    continue;
                }
                int maxGap = query(1,1,n,p1,p2-1);    //注意查询范围
                if(maxGap >= rain[p2]) {
                    System.out.println("false");
                    continue;
                }
                else {
                    System.out.println("maybe");
                    continue;
                }
            }
        }
    }
    static int low_bound(int l, int r, int v) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (year[mid] >= v) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
