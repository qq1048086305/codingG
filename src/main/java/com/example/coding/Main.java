package com.example.coding;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/10/30 19:09
 * @Version 1.0
 * @description:
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] DR = { 1, 0, -1, 0 };
    static int[] DC = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        while (true) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            if (H == 0) break;
            boolean[][] field = new boolean[H][W];
            int ar = 0;
            int ac = 0;
            int br = 0;
            int bc = 0;
            for (int i = 0; i < H; ++i) {
                String line = sc.next();
                for (int j = 0; j < W; ++j) {
                    if (line.charAt(j) == '#') {
                        field[i][j] = true;
                    }
                    if (line.charAt(j) == 'A') {
                        ar = i;
                        ac = j;
                    }
                    if (line.charAt(j) == 'B') {
                        br = i;
                        bc = j;
                    }
                }
            }
            String pattern = sc.next();
            int[][] turn = new int[H][W];
            for (int[] a : turn) {
                Arrays.fill(a, -1);
            }
            ArrayList<Point> cur = new ArrayList<Point>();
            turn[ar][ac] = 0;
            cur.add(new Point(ar, ac));
            int t = 1;
            while (!cur.isEmpty()) {
                ArrayList<Point> next = new ArrayList<Point>();
                for (Point p : cur) {
                    for (int i = 0; i < 4; ++i) {
                        int nr = p.x + DR[i];
                        int nc = p.y + DC[i];
                        if (nr == -1 || nr == H || nc == -1 || nc == W || turn[nr][nc] != -1 || field[nr][nc]) continue;
                        turn[nr][nc] = t;
                        next.add(new Point(nr, nc));
                    }
                }
                cur = next;
                ++t;
            }
            int ans = Integer.MAX_VALUE;
            int ansR = -1;
            int ansC = -1;
            for (int i = 0; i < 10000; ++i) {
                if (turn[br][bc] != -1 && turn[br][bc] <= i) {
                    ans = i;
                    ansR = br;
                    ansC = bc;
                    break;
                }
                char q = pattern.charAt(i % pattern.length());
                if (q == '8') {
                    if (br != 0) --br;
                } else if (q == '6') {
                    if (bc != W - 1) ++bc;
                } else if (q == '4') {
                    if (bc != 0) --bc;
                } else if (q == '2') {
                    if (br != H - 1) ++br;
                }
            }
            if (ans == Integer.MAX_VALUE) {
                System.out.println("impossible");
            } else {
                System.out.println(ans + " " + ansR + " " + ansC);
            }
        }
    }
}
