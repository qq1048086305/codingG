package com.example.coding.二分搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/14 10:32
 * @Version 1.0
 * @description:
 */
public class 数列分段 {
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
    //不就是跳石子变形？
    static int preSum[]=new int[(int)(1e5+10)];
    static int L,M;
    public static void main(String[] args) throws IOException {
        IO sc=new IO();
        int[] intArrPrim = sc.getIntArrPrim();
        L=intArrPrim[0];
        M=intArrPrim[1];
        int[] arrPrim = sc.getIntArrPrim();
        for (int i = 0; i < arrPrim.length; i++) {
            preSum[i+1]=arrPrim[i]+preSum[i];
        }
        int left=preSum[1];
        int right=preSum[L];
        int ans=Integer.MAX_VALUE;
        while (left<=right){
            int mid=(left+right)>>1;
            if(check(mid)){
                ans=Math.min(ans,mid);
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        System.out.println(ans);

    }

    private static boolean check(int mid) {
        //当前位置在Tmp： 上一个组位置在Pos
        int Pos = 0,Cnt = M,Tmp = 1;
        while(Cnt-->0)
        {   //如果当前组合适一直递增Tmp位置
            while(preSum[Tmp] - preSum[Pos] <= mid && Tmp <= L) Tmp ++;
            //到这里代表找出来了一组 记录非法组的Pos下标 Tmp加进来就不行了所以Tmp属于下一组
            //由前缀和定义来看Pos应该=tmp的上一个位置
            Pos = --Tmp;
            //如果当前Pos到了尾部而且总共的组数（cnt）也没用完就代表答案可行
            if(Pos == L) return true;
        }
        return false;
    }
}
