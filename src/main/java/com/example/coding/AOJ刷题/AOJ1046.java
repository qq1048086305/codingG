package com.example.coding.AOJ刷题;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/12/5 15:14
 * @Version 1.0
 * @description:
 */
//人想走怎么走就怎么走 所以优先选择走能到达所有点的最短时间价值
public class AOJ1046 {
    public static int h;//高
    public static int w;//宽
    public static char[] pattern;//幽灵移动mode

    public static char[][] map;//地图
    public static int[][] opt;
    public static int[][] move = {{1,0},{0,-1},{0,1},{-1,0},{0,0}};//人物可动5个选择
    //幽灵行动字符转方向跟move对应
    public static int getGhostMode(char c){
        return c=='2'?0:c=='4'?1:c=='6'?2:c=='8'?3:4;
    }
    public static int si;//人的位置
    public static int sj;//人的位置
    public static int ti;//幽灵位置
    public static int tj;//幽灵位置

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String ss[]=sc.readLine().split(" ");
            h = Integer.parseInt(ss[0]);
            w = Integer.parseInt(ss[1]);
            if(h==0&&w==0)break;//无意义break
            map = new char[h][w];//地图
            for(int i=0;i<h;i++){//一次读一行
                char[] s = sc.readLine().toCharArray();
                for(int j=0;j<w;j++){
                    map[i][j] = s[j];//赋值
                    if(s[j]=='A'){//找到人的位置默认为.
                        si = i;
                        sj = j;
                        map[i][j] = '.';
                    }
                    if(s[j]=='B'){//找到幽灵位置默认为.
                        ti = i;
                        tj = j;
                        map[i][j] = '.';
                    }
                }
            }
            //读入幽灵模式
            pattern = sc.readLine().toCharArray();
            //结果数组
            opt = new int[h][w];
            //默认无限大找最小值
            for(int[]a:opt) Arrays.fill(a, Integer.MAX_VALUE);
            //人物位置初始时间为0
            opt[si][sj] = 0;
            //来个链表
            //int[]相当于c++的pair队使用 0 和 1存两个数
            //模拟队列
            List<Point> list=new ArrayList<>();
            Queue<int[]> q=new LinkedList<>();
            //List<int[]> list = new ArrayList<int[]>();
            //list.add(new int[]{si,sj});
            list.add(new Point(si,sj));
            //初始距离为1
            int dis = 1;
            //这里不能用队列要用深搜

            while(!list.isEmpty()){
                //下一个链表
                List<Point> next = new ArrayList<Point>();
                for(Point p:list){
                    for(int k=0;k<4;k++){
                        //新的横坐标
                        int i = p.x + move[k][0];
                        //新的纵坐标
                        int j = p.y + move[k][1];
                        //判断当前到达位置是否合法 这个位置是否来过
                        if(0<=i&&i<h&&0<=j&&j<w&&map[i][j]=='.'&&opt[i][j]==Integer.MAX_VALUE){
                            opt[i][j] = dis;
                            next.add(new Point(i,j));
                        }
                    }
                }
                list=next;
                dis++;
            }
            int ans = 10000;
            int mi = 0;
            int mj = 0;
            //幽灵走的第几步
            int step = 0;
            //模拟幽灵走的过程
            //当前opt记录了每一个阶段所能带来的最小距离值
            /**
             * 例えば、pattern が "8544" の場合
             * 、幽霊は「北に1マス進む」
             * 「その場に留まる」
             * 「西に1マス進む」
             * 「西に1マス進む」
             * の行動パタンを繰り返す。
             *
             */
            while(step <= ans){
                //人能比幽灵更先到达这个点（人可以站着等它） 那么就更新答案
                if(opt[ti][tj]!=Integer.MAX_VALUE&&opt[ti][tj]<=step){
                    //步数比原来小更新答案
                    if(step < ans){
                        ans = step;
                        //记录幽灵在的位置
                        mi = ti;
                        mj = tj;
                        break;
                    }
                }
                //可以重复幽灵行动所以这里要取模
                int k = getGhostMode(pattern[step%pattern.length]);
                //幽灵走下一个
                step++;
                //幽灵走下一步到达的坐标
                int ni = ti + move[k][0];
                int nj = tj + move[k][1];
                //能走更新状态
                if(0<=ni&&ni<h&&0<=nj&&nj<w){
                    ti = ni;
                    tj = nj;
                }
            }
            System.out.println(ans==10000?"impossible":(ans+" " + mi + " " + mj));
        }
    }
}
