package com.example.coding.队列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/13 18:19
 * @Version 1.0
 * @description:
 */
public class 括号匹配 {
    static int a[]=new int[105]; // 标记
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
    public static void main(String[] args) throws IOException {
        int i,j;
        IO sc=new IO();
        String s;
        s=sc.getLine();
        for (i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')') { // 找到了右括号
                for (j=i-1; j>=0; j--) {
                    if (s.charAt(j) == '(' && a[j] == 0) { // 找到了没被匹配过的左括号且匹配成功
                        a[i] = a[j] = 1;
                        break;
                    }
                else if (s.charAt(j) == '[' && a[j] == 0) break; // 找到了左括号但匹配失败
                }
                // 找不到左括号，不做任何操作
            }
            // 下面同理
            else if (s.charAt(i) == ']') {
                for (j=i-1; j>=0; j--) {
                    if (s.charAt(j) == '[' && a[j] == 0) {
                        a[i] = a[j] = 1;
                        break;
                    }
                else if (s.charAt(j) == '(' && a[j] == 0) break;
                }
            }
        }
        for (i=0; i<s.length(); i++) {
            if (a[i] == 0) { // 没有匹配则成对输出
                if (s.charAt(i) == '(' || s.charAt(i) == ')') System.out.print("()");
            else System.out.print("[]");
            }
            else System.out.print(s.charAt(i)); // 匹配成功则直接输出
        }
    }

}
