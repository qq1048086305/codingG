package com.example.coding.队列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 神様だよ
 * @Date 2021/11/13 17:23
 * @Version 1.0
 * @description:
 */
//优先队列？
public class 海港 {
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
    static int n, t, m, x;
    static int temp_nation[]=new int[1000005];
    static int ans=0;

    static class Node
    {
        int s, t;
        //made in china
    }
    static Queue<Node> ship=new LinkedList<>();
    //java类不能共用因为new出来地址定了
    static Node h;
    public static void main(String[] args) throws IOException {
        IO sc=new IO();
        n = sc.getInt();
        int arr[];
        for(int i=1;i<=n;i++)
        {   arr=sc.getIntArrPrim();
            t=arr[0];
            m=arr[1];
            while(!ship.isEmpty())//只要还有人就对队列进行检查
            {
                h = ship.peek();//循环取队头（由于时间是单调递增的）
                if(h.t+86400<=t)//如果在时间外（不符合条件），则对答案和队列进行更新（删减）
                {
                    temp_nation[h.s]--;//这个国籍人数总数减1（因为这不是24小时内的人）
                    if(temp_nation[h.s]==0)   ans--;//如果这个国籍没有人了，则答案数减1（之前记过）
                    ship.poll();//把这个被时代所淘汰的人给丢掉
                    continue;//因为是单调递增的，所以有可能还会有，继续去找
                }
                break;//如果现在这个在24小时内，后面的肯定也符合条件，直接退出
            }
            for(int j=2;j<m+2;++j) //查完前面后，我们就对这只本身的船进行统计
            {
                x=arr[j];
                Node cur=new Node();
                cur.s = x;
                cur.t = t;//存进结构体
                ship.add(cur);//把这个人（结构体）给存进队列
                temp_nation[x]++;//这个国籍的人加1（桶排思想）
                if(temp_nation[x]==1)  ans++;//如果这个国籍是！相对！第一次出现，那么就算上他
            }
            System.out.printf("%d\n",ans);//模拟完了以后就输出答案
        }
    }
}
