package com.example.coding.leecode.动态规划;

/**
 * @Author 神様だよ
 * @Date 2021/12/3 9:58
 * @Version 1.0
 * @description:
 */
public class leecode123股票买卖3 {
    //在算法1中，由于取不同的分界点i时，求左边left的最大值时，枚举的j大多都是重复枚举过的，求右边right的最大值时，枚举的j大多也是重复枚举过的，因此重复枚举过的量可以把它记录下来
    //
    //1、f[i]表示的是所有从0到i，卖 - 买的最大值
    //2、g[i]表示的是所有从n - 1到i， 卖 - 买的最大值
    //3、minv记录的是[0, i - 1]的最小值，f[i] = max(f[i - 1], prices[i] - minv)
    //4、maxv记录的是[n - 1, i + 1]的最大值，g[i] = max(g[i + 1]， maxv - prices[i])
    //5、枚举所有的分界点i，去f[i] + g[i]的最大值
    //
    //作者：小呆呆
    //链接：https://www.acwing.com/solution/content/17801/
    //来源：AcWing
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/
}
