package com.example.coding.二分搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author 神様だよ
 * @Date 2021/11/14 9:39
 * @Version 1.0
 * @description:
 */
public class 挑石头 {
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
    static int a[]=new int[50005];
    static int L,n,k;
    public static void main(String[] args) throws IOException {
        IO sc=new IO();
        int[] intArrPrim = sc.getIntArrPrim();
        L=intArrPrim[0];
        n=intArrPrim[1];
        k=intArrPrim[2];
        for(int i=1;i<=n;i++){
            a[i]=sc.getInt();
        }
        a[n+1]=L ;
        int left=0;
        int right=L;
        int ans=Integer.MIN_VALUE;
        while (left<=right){
            int mid=(left+right)>>1;
            if(check(mid)){
                ans=Math.max(ans,mid);
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(ans);
    }
    //不满足条件就拿走一个石头 最后看看符合不符合
    private static boolean check(int mid) {
        int tot = 0;//tot代表计数器，记录以当前答案需要移走的实际石头数
        int i = 0;//i代表下一块石头的编号
        //起点是0别忘了
        int now = 0;//now代表模拟跳石头的人当前在什么位置
        while (i < n+1){//千万注意不是n，n不是终点，n+1才是
            i++;
            if (a[i] - a[now] < mid)//判断距离，看二者之间的距离算差值就好
                tot++;//判定成功，把这块石头拿走，继续考虑下一块石头
            else
                now = i;//判定失败，这块石头不用拿走，我们就跳过去，再考虑下一块
        }
        if (tot > k)
            return false;
        else
            return true;
    }
}
