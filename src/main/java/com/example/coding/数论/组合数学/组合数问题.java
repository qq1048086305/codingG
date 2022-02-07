package com.example.coding.数论.组合数学;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/16 13:53
 * @Version 1.0
 * @description:
 */
public class 组合数问题 {
    //题目问0->n 0≤j≤min(i,m),有多少对 (i,j)(i,j)满足组合数是k的倍数
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
    static long t,k,n,m,ans;
    static long c[][]=new long[2005][2005];

    //
    //答案的前缀和数组
    static long res[][]=new long[2005][2005];
    //阶乘函数
    static long ck(long x)//开long long可以算更多
    {
        if(x==0)return 1;
        int sum=1;
        for(int i=1;i<=x;i++)sum*=i;
        return sum;
    }
    static long C(long n,long m)
    {   //C n选m个数的组合数
        return ck(n)/(ck(m)*ck(n-m));//组合数公式
    }
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        k=sc.nextInt();
        while (t-->0){
            ans=0;
            n=sc.nextLong();
            m=sc.nextLong();

            for(long i=0;i<=n;i++)
                for(int j=0;j<=Math.min(m,i);j++)
                    if(C(i,j)%k==0)ans++;//统计
            System.out.printf("%d\n",ans);
        }
    }

    public static void main2(String[] args) {
        build();
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        k=sc.nextInt();
        while (t-->0){
            ans=0;
            n=sc.nextLong();
            m=sc.nextLong();
            for(int i=0;i<=n;i++)
                for(int j=0;j<=Math.min(i,m);j++)
                    if(c[i][j]%k==0)ans++;
            System.out.printf("%d\n",ans);
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        k=sc.nextInt();
        build2();
        while (t-->0){
            ans=0;
            n=sc.nextLong();
            m=sc.nextLong();
            if(m>n){
                System.out.printf("%d\n",res[(int)n][(int)n]);
            }else{
                System.out.printf("%d\n",res[(int)n][(int)m]);
            }
        }
    }
    //优化版 杨辉三角（组合数公式可以利用杨辉三角递推优化）
    static void build()//记得加入main函数，数组范围要开够，我就是在此RE。
    {   //https://www.luogu.com.cn/blog/cyx-TombRaider/p2822-zu-ge-shuo-wen-ti-ti-xie-by-hydranazis
        c[0][0]=1;
        c[1][0]=c[1][1]=1;//如上初始化，绝对绝对不能忘记或错，结合常识。
        for(int i=2;i<=2000;i++)
        {
            c[i][0]=1;
            for(int j=1;j<=2000;j++)//这不是此方法能承受的最大范围，打出题目要求的即可。
            {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
                //递推公式。
            }
        }
    }
    //再利用 二维前缀和进一步优化 （原理取模的答案不影响最终结果）

    static void build2()//记得加入main函数，数组范围要开够，我就是在此RE。
    {   //https://www.luogu.com.cn/blog/cyx-TombRaider/p2822-zu-ge-shuo-wen-ti-ti-xie-by-hydranazis
        c[0][0]=1;
        c[1][0]=c[1][1]=1;//如上初始化，绝对绝对不能忘记或错，结合常识。
        for(int i=2;i<=2000;i++)
        {
            c[i][0]=1;
            for(int j=1;j<=2000;j++)//这不是此方法能承受的最大范围，打出题目要求的即可。
            {
                c[i][j] = (c[i - 1][j - 1] +c[i - 1][j]) % k;
                //递推公式。
                res[i][j] = res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1];
                if (c[i][j]==0) {//
                    res[i][j]++;
                }
            }
            //回复二楼，杨辉三角的右边是没有办法这样更新的，这样是为了更新
            //由于ans数组呈杨辉三角状
            // 所以ans[i][i]=ans[i][i-1],
            res[i][i+1]=res[i][i];
        }
    }
}
