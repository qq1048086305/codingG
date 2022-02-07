package com.example.coding.AOJ刷题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/4 22:04
 * @Version 1.0
 * @description:
 */
public class AOJ1043 {
    //排序+模拟
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            int n=sc.nextInt();
            if(n==0){
                return;
            }
            Team team[]=new Team[n];
            for(int i=0;i<n;i++){
                int id,t,score,p;
                id=sc.nextInt();
                t=sc.nextInt();
                score=sc.nextInt();
                p=sc.nextInt();
                team[i]=new Team(id,t,score,p);
            }
            Arrays.sort(team);
            //その時点で選抜されたチームの数が
            int count[]=new int[n+1];//一个桶记录当前队伍几个了
            int pass=0;//当前选了多少人
            for(int i=0;i<n;i++){
                Team curTeam=team[i];
                if(pass<10&&count[curTeam.t]<3||pass<20&&count[curTeam.t]<2||pass<26&&count[curTeam.t]<1){
                    pass++;
                    count[curTeam.t]++;
                    System.out.println(curTeam.id);
                }
            }
        }
    }
    public static class Team implements Comparable<Team>{
        public Team(int id, int t, int score, int p) {
            this.id = id;
            this.t = t;
            this.score = score;
            this.p = p;
        }

        int id;//问题id
        int t;//所属队伍编号
        int score;//正解数量
        int p;//ペナルティ
        //排序
        @Override
        public int compareTo(Team o) {
            if(this.score!=o.score){
                return o.score-this.score;
            }
            if(this.p!=o.p){
                return this.p-o.p;
            }
            return this.id-o.id;
        }
        /**
         * より多くの問題を解いたチームが上位となります。
         * 解いた問題数が同じ場合は、ペナルティが小さいチームが上位となります。
         */


    }
}
