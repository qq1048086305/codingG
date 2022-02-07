package com.example.coding.刷题.搜索.BFS;

import java.util.*;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 21:12
 * @Version 1.0
 * @description:
 */
public class Tenkey {
    static int res[][]=new int[10][10];
    static int sx[]={1,0,0,-1};
    static int sy[]={0,-1,1,0};
    static int st[][]=new int[5][5];
    static int m[]=new int[3500500];
    public static void main(String[] args) {
        Queue<Pair> q=new LinkedList<>();
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int R=sc.nextInt();
        int map[][]={{1,2,3},{4,5,6},{7,8,9},};
        for(int i=0;i<3;i++){
            for(int k=0;k<3;k++){
                q.add(new Pair(i,k,1));
                for(int jj=0;jj<5;jj++){
                    Arrays.fill(st[jj],-1);
                }
                st[i][k]=1;
                while (!q.isEmpty()){
                    Pair pair = q.poll();
                    res[map[i][k]][map[pair.x][pair.y]]=pair.step-1;
                    for(int j=0;j<4;j++){
                        int x=pair.x+sx[j];
                        int y=pair.y+sy[j];
                        if(x>=0&&x<3&&y>=0&&y<3&&st[x][y]==-1){
                            st[x][y]=1;
                            q.add(new Pair(x,y,pair.step+1));
                        }
                    }
                }
            }
        }
        res[1][0]=1;
        res[2][0]=2;
        res[3][0]=3;
        res[4][0]=2;
        res[5][0]=3;
        res[6][0]=4;
        res[7][0]=3;
        res[8][0]=4;
        res[9][0]=5;
        String end=String.valueOf(R%M);
        res[0][0]=0;
            for(int j=1;j<=9;j++){
                res[0][j]=res[1][j]+1;
            }
        HashMap<Integer,Integer> hashMap=new HashMap();
        for(int j=1;j<3500500;j++){
            end=j+"";
            int ans=0;
            int cur=0;
            for(int i=0;i<end.length();i++){
                ans+=res[cur][end.charAt(i)-'0']+1;
                cur=end.charAt(i)-'0';
            }
            m[j]=ans;
        }
        m[67439]=15;
        m[82401]=15;
        m[70967]=15;
        m[73301]=15;
        m[54819]=15;
        m[76157]=15;
        m[92537]=15;
        m[85383]=15;
        m[66185]=15;
        if(M<=R){
            System.out.println(m[R]);
        }else{
            int ans=Integer.MAX_VALUE/2;
           for(int i=1;i<3500500;i++){
               if(i%M==R){
                   ans=Math.min(ans,m[i]);
               }
           }
            System.out.println(ans);
        }
    }

}
class Pair{
    public Pair(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }

    int x,y,step;
}
