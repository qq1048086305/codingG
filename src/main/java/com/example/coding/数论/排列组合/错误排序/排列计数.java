package com.example.coding.数论.排列组合.错误排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @Author 神様だよ
 * @Date 2021/11/25 14:42
 * @Version 1.0
 * @description:
 */
public class 排列计数 {
    //https://zsf--zs---233.blog.luogu.org/solution-p4071

    static int N=1000010;
    static int M=1010;
    static long mod =(long) 1e9 + 7;
    static long t,  f[]=new long[N], jc[]=new long[N];
    static int n,m;
    static long q_pow(long a, long b) {
        long ans = 1;
        while (b>0) {
            if ((b & 1)==1) ans = (ans * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return ans;
    }

    static long c(int a, int b) { //组合数
        return (jc[a] % mod * q_pow(jc[b] * jc[a - b] % mod, mod - 2) % mod) % mod;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(sc.readLine().trim());
        f[1] = 0;
        f[2] = 1;
        jc[1] = 1;
        jc[2] = 2;
        for (int i = 3; i <= 1000000; i++){
            f[i] = ((i - 1) * (f[i - 1] + f[i - 2]) % mod) % mod;
            jc[i] = (jc[i - 1] * i) % mod;
        }
        PrintWriter cout=new PrintWriter(System.out);
        String s[];
        while (t-->0) {
            s=sc.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            if (n == m) cout.printf("1\n");
            else if (n - m == 1) cout.printf("0\n");
            else if (m == 0) cout.printf("%d\n",f[n]);
            else {
                long ans = (f[n - m] % mod * c(n, m)) % mod;
                cout.printf("%d\n", ans);
            }
        }
        cout.close();
    }

}
