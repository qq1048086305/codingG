package com.example.coding.数组型线段树.离散化扫描线;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/19 17:24
 * @Version 1.0
 * @description:
 */
public class 窗口的星星 {
    static int maxn=(int)1e4+10;
    static int n,tot,w,h;
    static int yy[]=new int[maxn<<1];//离散化的y轴
    static int rm[]=new int[maxn<<3],flag[]=new int[maxn<<3];//rm表示区间最大值，flag为懒标记 八倍数组，因为2n条线段，线段树要4倍。
    static class  Line implements Comparable<Line>
    {
        int x,y1,y2,c;
        Line(int xx,int yy1,int yy2,int cc){x=xx;y1=yy1;y2=yy2;c=cc;}

        @Override
        public int compareTo(Line o) {
            if(this.x==o.x){
                return o.c-this.c;
            }else{
                return this.x-o.x;
            }
        }
    }
    static Line line[]=new Line[maxn<<1];
    static void pushdown(int t,int l,int r)//下传懒标记
    {
        if(flag[t]==0)return;
        rm[t]+=flag[t];
        if(l!=r)		//这里主要防止越界
        {
            flag[t<<1]+=flag[t];
            flag[t<<1|1]+=flag[t];
        }
        flag[t]=0;
    }
    static void modify(int t,int l,int r,int x,int y,int z)//区间修改
    {
        if(x<=l&&r<=y)
        {
            flag[t]+=z;
            return;
        }
        int mid=(l+r)>>1;
        if(x<=mid)modify(t<<1,l,mid,x,y,z);
        if(y>mid)modify(t<<1|1,mid+1,r,x,y,z);
        pushdown(t<<1,l,mid);
        pushdown(t<<1|1,mid+1,r);
        rm[t]=Math.max(rm[t<<1],rm[t<<1|1]);	//回传最值
    }

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(sc.readLine().trim());
        String s[];
        while (t-->0){
            s=sc.readLine().split("\\s+");
            n=Integer.parseInt(s[0]);
            w=Integer.parseInt(s[1]);
            h=Integer.parseInt(s[2]);
            for(int i=1;i<=n;i++){
                int x,y,c;
                s=sc.readLine().split("\\s+");
                x=Integer.parseInt(s[0]);
                y=Integer.parseInt(s[1]);
                c=Integer.parseInt(s[2]);
                line[i]=new Line(x,y,y+h-1,c);
                line[i+n]=new Line(x+w-1,y,y+h-1,-c);
                yy[i]=y+h-1;
                yy[i+n]=y;
            }
            n<<=1;//处理的是2n条线段
            Arrays.sort(yy,1,n+1);
            int tot = 0;
            yy[0]=-99999;
            //去重  离散化
            for (int i = 1; i <= n; i++) {
                if (yy[i] != yy[tot]) {
                    yy[++tot] = yy[i];
                }
            }
            Arrays.sort(line, 1,n+1);//根据横坐标排序
            int ans=0;
            for(int i=1;i<=n;i++)
            {
                int l=low_bound(1,tot+1,line[i].y1);//二分离散化
                int r=low_bound(1,tot+1,line[i].y2);
                //modify(1,1,tot,l,r,line[i].c);//修改，这里注意是l和r，一开始我写的r-1竟然对了9个（但实际上是错误的）
                ans=Math.max(ans,rm[1]);//每次更新最值
            }
            out.printf("%d\n",ans);
            out.flush();
        }
    }
    static int low_bound(int l, int r, int v) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (yy[mid] >= v) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
