package com.example.coding.acwing蓝桥杯;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @Author 神様だよ
 * @Date 2021/12/10 18:17
 * @Version 1.0
 * @description:
 */
public class 飞行员兄弟 {
    static char map[][]=new char[4][4];
    static ArrayList<Point> ans=new ArrayList<>();
    static ArrayList<Point> tmp=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter cout=new PrintWriter(System.out);
        for(int i=0;i<4;i++){
            map[i]=sc.readLine().toCharArray();
        }
        dfs(0,0);//从0 0点开始试一遍
        cout.println(ans.size());
        for (Point an : ans) {
            cout.printf("%d %d\n",an.x+1,an.y+1);
        }
        cout.close();

    }

    private static void dfs(int x, int y) {
        if(x==3&&y==4){
            boolean success = true;
            for(int i=0;i<4;i++){
                if(!success){
                    break;
                }
                for(int j=0;j<4;j++){
                    if(map[i][j]=='+'){
                        success=false;
                        break;
                    }
                }
            }
            if(success){
                if(ans.size()>tmp.size()||ans.size()==0){
                    ans=new ArrayList<>(tmp);
                }
            }
            return;
        }
        if(y==4){
            x++;
            y=0;
        }
        turnAll(x,y);
        tmp.add(new Point(x,y));
        dfs(x,y+1);//按下一个
        //不按
        turnAll(x,y);
        tmp.remove(tmp.size()-1);
        dfs(x,y+1);
    }

    private static void turnAll(int x, int y) {
        for(int i=0;i<4;i++){
            turn_one(i,y);
        }
        for(int i=0;i<4;i++){
            turn_one(x,i);
        }
        turn_one(x,y);//多转了一次转回来

    }
    static void turn_one(int x, int y)
    {
        if (map[x][y] == '+') map[x][y] = '-';
        else map[x][y] = '+';
    }
}
