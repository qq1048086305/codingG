package com.example.coding.排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 14:50
 * @Version 1.0
 * @description:
 */
public class 分数线划定 {
    public static void main(String[] args) throws IOException {
        IO sc=new IO();
        int a[]=sc.getIntArrPrim();
        int n=a[0];
        int m=a[1];
        /**
         * m×150%=3×150%=4.5，
         * 向下取整后为4。
         * 保证4个人进入面试的分数线为8888，
         * 但因为88有重分，所以所有成绩大于等于88的选手都可以进入面试，故最终有5个人进入面试。
         */
        int p=(int)(m*1.5);//面试的总人数
        Pair emp[]=new Pair[5005];
        for (int i = 1; i <=n ; i++) {
            a=sc.getIntArrPrim();
            emp[i]=new Pair(a[0],a[1]);
        }
        Arrays.sort(emp, 1, n+1);
        int limit=emp[p].score;
        int limitId=emp[p].id;
        for(int i=p+1;i<=n;i++){
            if(emp[i].score==limit){
                p++;
            }
        }
        System.out.println(limit+" "+p);
        for(int i=1;i<=p;i++ ){
            System.out.println(emp[i].id+" "+emp[i].score);
        }


    }

}
class Pair implements Comparable<Pair>{
    int id;
    int score;

    public Pair(int id, int score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Pair o) {
        if(o.score==this.score){
            return this.id-o.id;
        }else {
            return o.score-this.score;
        }
    }
}
class IO {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public IO() {

    }

    public void println(String str) {
        System.out.println(str);
    }

    public void printArr(Object o[]) {
        for (int i = 0; i < o.length; i++) {
            System.out.print(o + " ");
        }
        System.out.println();
    }

    public int getInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public long getLong() throws IOException {
        return Long.parseLong(br.readLine());
    }

    public double getDouble() throws IOException {
        return Double.parseDouble(br.readLine());
    }

    public String getLine() throws IOException {
        return br.readLine();
    }

    public int[] getIntArrPrim() throws IOException {
        String str[] = br.readLine().split(" ");
        int a[] = new int[str.length];

        for (int i = 0; i < str.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }

        return a;
    }

    public Integer[] getIntArr() throws IOException {
        String str[] = br.readLine().split(" ");
        Integer a[] = new Integer[str.length];

        for (int i = 0; i < str.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }

        return a;
    }

    public Long[] getLongArr() throws IOException {
        String str[] = br.readLine().split(" ");
        Long a[] = new Long[str.length];

        for (int i = 0; i < str.length; i++) {
            a[i] = Long.parseLong(str[i]);
        }

        return a;
    }

    public long[] getLongArrPrim() throws IOException {
        String str[] = br.readLine().split(" ");
        long a[] = new long[str.length];

        for (int i = 0; i < str.length; i++) {
            a[i] = Long.parseLong(str[i]);
        }

        return a;
    }

    public String[] getStrArr(String split) throws IOException {
        return br.readLine().split(split);
    }

    public char[] getCharArr() throws IOException {
        return br.readLine().toCharArray();
    }

    public int[][] getIntMap(int w, int h, String split) throws IOException {
        int a[][] = new int[h][w];

        for (int i = 0; i < h; i++) {
            String str[] = br.readLine().split(split);
            for (int j = 0; j < w; j++) {
                a[i][j] = Integer.parseInt(str[j]);
            }
        }

        return a;
    }

    public long[][] getLongMap(int w, int h, String split) throws IOException {
        long a[][] = new long[h][w];

        for (int i = 0; i < h; i++) {
            String str[] = br.readLine().split(split);
            for (int j = 0; j < w; j++) {
                a[i][j] = Long.parseLong(str[j]);
            }
        }

        return a;
    }

    public double[][] getDoubleMap(int w, int h, String split) throws IOException {
        double a[][] = new double[h][w];

        for (int i = 0; i < h; i++) {
            String str[] = br.readLine().split(split);
            for (int j = 0; j < w; j++) {
                a[i][j] = Double.parseDouble(str[j]);
            }
        }

        return a;
    }

    public char[][] getCharMap(int w, int h, String split) throws IOException {
        char a[][] = new char[h][w];

        for (int i = 0; i < h; i++) {
            String str[] = br.readLine().split(split);
            for (int j = 0; j < w; j++) {
                a[i][j] = str[j].charAt(0);
            }
        }

        return a;
    }
}
