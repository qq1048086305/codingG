package com.example.coding.刷题.水题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @Author 神様だよ
 * @Date 2021/11/11 12:18
 * @Version 1.0
 * @description:
 */
public class TarosShopping {
    public static void main(String[] args) throws IOException {
        IO sc=new IO();
        while (true){
            int query[]=sc.getIntArrPrim();
            int n=query[0];
            int sum=query[1];
            if(n==0&&sum==0){
                return;
            }
            int[] arr = sc.getIntArrPrim();
            Arrays.sort(arr);
            int ans=Integer.MIN_VALUE;
            s1:for(int i=n-1;i>=1;i--){
                for(int j=i-1;j>=0;j--){
                    /*if(arr[i]+arr[j]>sum){
                        break;
                    }*/
                    if(arr[i]+arr[j]<=sum){
                        ans=Math.max(arr[i]+arr[j],ans);
                    }
                }
            }
            if(ans==Integer.MIN_VALUE){
                System.out.println("NONE");
            }else{
                System.out.println(ans);
            }
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