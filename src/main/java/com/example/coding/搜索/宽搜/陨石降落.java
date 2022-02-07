package com.example.coding.搜索.宽搜;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/13 15:29
 * @Version 1.0
 * @description:
 */
public class 陨石降落 {
    static int n,ma[][]=new int[305][305],v[][]=new int[305][305],sx,sy,st,ans[][]=new int[305][305];//分别为陨石数量，陨石砸落地图，记录是否走过地图，陨石x,y坐标及砸落时间，每个点的最少时间图。
    static int dx[]={0,0,0,1,-1};
    static int dy[]={0,1,-1,0,0};//方便移动和处理陨石砸落
    static int ch(int a){
        if (a==-1) return 99999;
        else return a;
    }//判断路过该点时是否陨石已经砸落，如果是没有陨石，相当于n年后砸落

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        for (int i=0;i<305;i++){
            for (int j=0;j<305;j++){
                ma[i][j]=-1;
            }
        }//陨石初始化为-1
        for (int i=1;i<=n;i++){
            sx=sc.nextInt();
            sy=sc.nextInt();
            st=sc.nextInt();
            for (int j=0;j<5;j++){//上下左右中标记陨石
                //以最早时间处理陨石坠落时间
                if (sx+dx[j]>=0&&sy+dy[j]>=0&&(ma[sx+dx[j]][sy+dy[j]]==-1||ma[sx+dx[j]][sy+dy[j]]>st))//如果该标记x,y坐标大于0且该点没有被陨石砸落或已标记时间没有该时间早，标记陨石
                    ma[sx+dx[j]][sy+dy[j]]=st;
            }
        }
        Queue<Pair> q =new LinkedList<>();//构造队列，存储将处理点x,y坐标
        v[0][0]=1;//初始点设为已走过
        q.add(new Pair(0, 0,0));
        while (!q.isEmpty()){//只要队列不为空
            Pair cur=q.poll();
            int x,y;//当前状态在的位置
            x=cur.x;
            y=cur.y;
            int s=cur.time+1;//即将标记的点时间是现在点的下一个单位
            if (ma[x][y]==-1){ //如果该点安全，输出即将标记的点的时间-1
                System.out.printf("%d\n",s-1);
                return;
            }
            for (int i=1;i<=4;i++){
                int xx=x+dx[i],yy=y+dy[i];//提取将处理点的坐标
                if (xx>=0&&yy>=0&&s<ch(ma[xx][yy])&&v[xx][yy]==0){//将处理点需要x,y坐标大于等于0且该点没有走过并且陨石降落时间小于现时间
                    q.add(new Pair(xx,yy,s));
                    v[xx][yy]=1;//标记已走过
                }
            }
        }
        System.out.printf("-1\n");//如果出不了陨石区，输出-1
    }
    static class Pair{
        int x,y,time;
        public Pair(int x, int y,int time) {
            this.x = x;
            this.y = y;
            this.time=time;
        }
    }
}
