package com.example.coding.acwing蓝桥杯.树状数组和线段树;

/**
 * @Author 神様だよ
 * @Date 2021/12/19 18:46
 * @Version 1.0
 * @description:
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 三维查分三体 {
    static int[][][] delta;
    static int[][][] nums;
    static int[][] oper;
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] fl = bf.readLine().split(" ");
        A = Integer.parseInt(fl[0]);
        B = Integer.parseInt(fl[1]);
        C = Integer.parseInt(fl[2]);
        int m = Integer.parseInt(fl[3]);
        delta = new int[A+2][B+2][C+2];
        nums = new int[A+2][B+2][C+2];
        oper = new int[m+1][7];
        String[] numLine = bf.readLine().split(" ");
        int index = 0;
        //读入源数组，顺带构建差分数组
        for (int i = 1; i <= A ; i++) {
            for (int j = 1; j <=B ; j++) {
                for (int k = 1; k <=C ; k++) {
                    nums[i][j][k] = Integer.parseInt(numLine[index++]);
                    add(i,i,j,j,k,k,nums[i][j][k]);
                }
            }
        }
        //读入操作
        for (int i = 1; i <=m ; i++) {
            String[] operLine = bf.readLine().split(" ");
            int x1 = Integer.parseInt(operLine[0]);
            int x2 = Integer.parseInt(operLine[1]);
            int y1 = Integer.parseInt(operLine[2]);
            int y2 = Integer.parseInt(operLine[3]);
            int z1 = Integer.parseInt(operLine[4]);
            int z2 = Integer.parseInt(operLine[5]);
            int h = Integer.parseInt(operLine[6]);
            oper[i] = new int[]{x1,x2,y1,y2,z1,z2,-h};
        }
        int l = 1;
        int r = m;
        while (l < r){
            int mid = (l + r) >> 1;
            if(check(mid)){
                //没出有爆炸返回true，否则返回false
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        System.out.println(r);
    }

    private static void add(int x1, int x2, int y1, int y2, int z1, int z2, int val) {
        delta[x1][y1][z1] += val;
        delta[x1][y2+1][z1] -= val;
        delta[x2+1][y1][z1] -= val;
        delta[x2+1][y2+1][z1] += val;
        delta[x1][y1][z2+1] -= val;
        delta[x1][y2+1][z2+1] += val;
        delta[x2+1][y1][z2+1] += val;
        delta[x2+1][y2+1][z2+1] -= val;
    }

    private static boolean check(int mid) {
        int[][][] back = new int[A + 2][B +2][C + 2];
        for (int i = 1; i <= A ; i++) {
            for (int j = 1; j <=B ; j++) {
                for (int k = 1; k <=C ; k++) {
                    back[i][j][k] = delta[i][j][k];
                }
            }
        }
        for (int i = 1; i <= mid; i++) {
            add(    oper[i][0],oper[i][1],
                    oper[i][2],oper[i][3],
                    oper[i][4],oper[i][5],
                    oper[i][6]);
        }
        //求源数组
        for (int i = 1; i <= A ; i++) {
            for (int j = 1; j <=B ; j++) {
                for (int k = 1; k <=C ; k++) {
                    nums[i][j][k] = delta[i][j][k] + nums[i-1][j][k] + nums[i][j-1][k] - nums[i-1][j-1][k]
                            + nums[i][j][k-1] - nums[i-1][j][k-1] - nums[i][j-1][k-1] + nums[i-1][j-1][k-1];
                    if (nums[i][j][k] < 0){
                        delta = back;
                        return false;
                    }
                }
            }
        }
        delta = back;
        return true;
    }

}