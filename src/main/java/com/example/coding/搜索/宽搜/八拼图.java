package com.example.coding.搜索.宽搜;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Author 神様だよ
 * @Date 2021/11/6 13:00
 * @Version 1.0
 * @description:
 */
@SuppressWarnings("unchecked")
public class 八拼图 {
    /*static int f(String status){
        int res = 0;
        for(int i = 0; i < status.length(); i ++)
            if(status.charAt(i)!= '0'){
                int t = status.charAt(i) - '1';
                res += Math.abs(t / 4 - i / 4) + Math.abs(t % 4 + i % 4);
            }
        return res;
    }*/
    static String end="123456789abcdef0";
    static Set<String> set=new HashSet<>();
    static int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        String map[]={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        Scanner scc=new Scanner(System.in);
        String start="";
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                start+=map[scc.nextInt()];
            }
        }
        Queue<Pair> q=new LinkedList();
        q.add(new Pair(start,0));
        set.add(start);
        while (!q.isEmpty()){
            Pair cur=q.poll();
            if(cur.ss.equals(end)){
                System.out.println(cur.step);
                return;
            }
            int index=cur.ss.indexOf('0');//找到0在的地方
            char[] str = cur.ss.toCharArray();
            /**
             * 我们这里需要求出原数组内的下标然后处理那么如何求
             */
            int x = index / 4, y = index % 4;
            for(int i=0;i<4;i++){
                int xx=x+dx[i];
                int yy=y+dy[i];
                if(xx>=0&&xx<4&&yy>=0&&yy<4){
                  int t=xx*4+yy;
                  char tmp=str[index];
                  str[index]=str[t];
                  str[t]=tmp;
                  String to=new String(str);
                  if(!set.contains(to)){
                      set.add(to);
                      q.add(new Pair(to,cur.step+1));
                  }
                  tmp=str[index];
                  str[index]=str[t];
                  str[t]=tmp;
                }
            }
        }
    }
    static class Pair{
        String ss;

        public Pair(String ss, int step) {
            this.ss = ss;
            this.step = step;
        }

        int step;
    }
}
