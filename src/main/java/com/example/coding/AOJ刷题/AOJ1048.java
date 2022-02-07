package com.example.coding.AOJ刷题;

import java.io.IOException;
import java.util.*;

/**
 * @Author 神様だよ
 * @Date 2021/12/5 17:04
 * @Version 1.0
 * @description:
 */
public class AOJ1048 {
    //https://onlinejudge.u-aizu.ac.jp/challenges/sources/UOA/PCKWU/1048

    //给你三组数据 第一组  每个店(1-n)有的商品和对应花费

    //第二组 当前琴子需要哪些商品

    //第三组 无向图的边连接关系

    //问：琴子从自己家0 买商品 满足第二组的条件下 最小花费且距离最短(要回到家)的答案这两个值是多少
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        //输入
        Scanner scanner = new Scanner(System.in);
        loop: while (true) {
            //每家店卖的多少商品
            int n = scanner.nextInt();
            if (n == 0)
                break;
            Map<String, Integer>[] supers = new Map[n];
            for (int i = 0; i < n; i++)
                supers[i] = new HashMap<String, Integer>();
            Map<String, Integer> min = new HashMap<String, Integer>();
            for (int i = 0; i < n; i++) {
                //当前店卖k个商品
                int k = scanner.nextInt();
                for (int j = 0; j < k; j++) {
                    //商品名
                    String name = scanner.next();
                    //价格
                    int value = scanner.nextInt();
                    //储存当前店含有的商品名字和价格
                    supers[i].put(name, value);
                    if (!min.containsKey(name) || min.get(name) > value) {
                        //存储最低价格对应商品名
                        min.put(name, value);
                    }
                }
            }
            //需要的商品数
            int q = scanner.nextInt();
            String[] name = new String[q];
            //保存需要的商品名
            for (int i = 0; i < q; i++)
                name[i] = scanner.next();
            int m = scanner.nextInt();
            //存储每个节点对应的信息
            List<Point>[] lists = new List[n + 1];
            for (int i = 0; i <= n; i++)
                lists[i] = new ArrayList<Point>();
            while (m-- > 0) {
                //s->t距离为d
                int s = scanner.nextInt();
                int t = scanner.nextInt();
                int d = scanner.nextInt();
                //建立邻接表存图
                lists[s].add(new Point(t, d));
                lists[t].add(new Point(s, d));
            }
            //找最小花费
            int sum = 0;
            for (int i = 0; i < q; i++) {
                //如果店里没有这个商品 输出impossible 去处理下一组了
                if (!min.containsKey(name[i])) {
                    System.out.println("impossible");
                    continue loop;
                }
                //累加最小花费
                sum += min.get(name[i]);
            }
            //存储最短路
            //节点 二进制状态
            int[][] dp = new int[n + 1][1 << q];
            //默认最大值
            for (int[] dp1 : dp)
                Arrays.fill(dp1, 1 << 20);
            //优先队列
            PriorityQueue<Point> pq = new PriorityQueue<Point>();
            //bit从零开始 代表商品状态
            pq.offer(new Point(0, 0, 0));
            int ans = 0;
            int[] bits = new int[n];
            for (int i = 0; i < n; i++) {
                int bit = 0;
                //枚举每个店铺最小值的二进制状态存到bit数组里
                for (int j = 0; j < q; j++) {
                    //当前i店铺是否含有name商品 b并且含有最小花费的该商品 把当前这个位置的二进制
                    if (supers[i].containsKey(name[j])
                            && supers[i].get(name[j]).equals(min.get(name[j])))
                        bit |= 1 << j;
                }
                //第i个店拥有答案的状态
                bits[i] = bit;
            }
            //开始从根节点找最短路

            //优先队列中的cost是从根节点到上一个节点的距离
            while (!pq.isEmpty()) {
                Point p = pq.poll();
                int t = p.t;
                int cost = p.cost;
                int bit = p.bit;
                //如果达到最终状态 （琴子家 并且物品买齐）
                if (t == 0 && bit == (1 << q) - 1) {
                    //记录答案结束搜索
                    ans = cost;
                    break;
                }
                //如果从家到当前的路长度比现在所到长度还要小
                if (dp[t][bit]< cost)
                    continue;
                //否则更新距离
                dp[t][bit] = cost;
                //状态转移
                if (t > 0)
                    //加当前店的商品状态 （从0开始要-1）
                    bit |= bits[t - 1];
                for (Point point : lists[t])
                    pq.offer(new Point(point.t, cost + point.cost, bit));

            }
            System.out.println(sum + " " + ans);
        }
    }
    static class Point implements Comparable<Point> {
        //相邻节点编号 距离花费cost 当前位置拥有的商品状态
        int t, cost, bit;

        @Override
        public String toString() {
            return "Point [t=" + t + ", cost=" + cost + ", bit=" + bit + "]";
        }

        public Point(int t, int cost, int bit) {
            super();
            this.t = t;
            this.cost = cost;
            this.bit = bit;
        }

        public Point(int t, int cost) {
            super();
            this.t = t;
            this.cost = cost;
        }

        @Override
        //按花费从小到大排序 如果花费相等按当前有的商品个数从大到小排序
        public int compareTo(Point o) {
            if (cost == o.cost)
                return o.bit - bit;
            return cost - o.cost;
        }
    }
}
