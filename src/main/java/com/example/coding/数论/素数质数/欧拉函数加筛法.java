package com.example.coding.数论.素数质数;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/18 11:09
 * @Version 1.0
 * @description:
 */
//https://www.luogu.com.cn/blog/SuperTNT/solution-p3601
public class 欧拉函数加筛法 {
    /**
     * 欧拉函数原理文章
     * https://blog.csdn.net/Qiuker_jl/article/details/109587507?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522163722054216780271531663%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=163722054216780271531663&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_click~default-3-109587507.first_rank_v2_pc_rank_v29&utm_term=%E6%AC%A7%E6%8B%89%E5%87%BD%E6%95%B0&spm=1018.2226.3001.4187
     */
    static int MAXN = (int)1e6 + 10;
    static int mod = 666623333;

    static long phi[]=new long[MAXN];//phi[]求欧拉函数,vis[]是为了判断一个数是否可以分解出大质数
    static long vis[]=new long[MAXN];
    static int prime[]=new int[MAXN], tot;
    static boolean mindiv[]=new boolean[MAXN];

    static void ES(long n)//线性筛质数
    {
        for (int i = 2; i <= n; i++)
        {
            if (!mindiv[i])
                prime[++tot] = i;
            for ( int j = 1; j <= tot && prime[j] * i <= n; j++)
            {
                mindiv[prime[j] * i] = true;
                if ((i % prime[j])==0)
                    break;
            }
        }
    }

    public static void main(String []args)
    {
        long l, r;
        Scanner sc=new Scanner(System.in);
        l=sc.nextLong();
        r=sc.nextLong();
        //vis 和 phi是模板数组 vis记录每个数值，初始化对应值
        //假设有对应数值的互质数 然后去减去对应的非素数值 根据欧拉函数原理
        for (int i = 0; i <= r - l; i++)
        vis[i] = phi[i] = i + l;
        ES((int)Math.sqrt(r));
        for (int i = 1; i <= tot && prime[i] * prime[i] <= r; i++)
        {
            int p = prime[i];//对于每1个小于1e6的质数，对它的倍数求一次欧拉函数
            //类似于筛合数 从第一个比l大的p倍数开始
            //所有含有这个素数的值对应的欧拉函数值都求一下
            for ( long j = (p - l % p) % p; j <= r - l; j += p)
            {
                phi[(int)j] = phi[(int)j] * (p - 1)/ p ;
                while ((vis[(int)j] % p)==0)//同时使该数不还有该质因子
                    vis[(int)j] /= p;
            }
        }

        long ans = 0;
        for ( int i = 0; i <= r - l; i++)
        {   //相当于求单个的函数最后一步 判断是不是剩下了一个质数 给它减掉
            if (vis[i] != 1)//求是否有大质数
                phi[i] = phi[i] / vis[i] * (vis[i] - 1);
            ans = 1l * (ans + i + l - phi[i]) % mod;//统计答案
        }

        System.out.printf("%d\n", ans);
        return;
    }
}
