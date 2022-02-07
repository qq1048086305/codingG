package com.example.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 15:54
 * @Version 1.0
 * @description:
 */
public class 动态规划 {
    static int dp[][]=new int[25][25];
    static int arr[][]=new int[25][25];
    public static void main(String[] args) throws IOException {
       IO sc=new IO();
        int[] arrPrim = sc.getIntArrPrim();
        int a,b,c,d;
        a=arrPrim[0]+1;
        b=arrPrim[1]+1;
        c=arrPrim[2]+1;
        d=arrPrim[3]+1;
        arr[c][d]=-1;
        arr[c-2][d+1]=-1;
        arr[c-2][d-1]=-1;
        arr[c+2][d-1]=-1;
        arr[c+2][d-1]=-1;
        arr[c+1][d-2]=-1;
        arr[c-1][d-2]=-1;
        arr[c+1][d+2]=-1;
        arr[c-1][d+2]=-1;
        dp[1][1]=1;
        for(int i=1;i<=a;i++){
             for(int j=1;j<=b;j++){
                 if(arr[i][j]==-1){
                     continue;
                 }
                 if(i==1){
                     dp[i][j]+=dp[i-1][j];
                 }else if(j==1){
                         dp[i][j]+=dp[i][j-1];
                 }else{
                     dp[i][j]+=dp[i-1][j]+dp[i][j-1];
                 }
             }
        }
        System.out.println(dp[a][b]);
    }
    static class IO {
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
}
