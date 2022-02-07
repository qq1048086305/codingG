package com.example.coding.util;

import java.io.InputStream;
import java.util.NoSuchElementException;

/**
 * @Author 神様だよ
 * @Date 2021/11/9 13:02
 * @Version 1.0
 * @description:
 */
public class FastScanner {
    private InputStream in = System.in;
    private byte[] buffer = new byte[1024];
    private int length = 0, p = 0;
    private boolean hasNextByte() {
        if (p < length) return true;
        else{
            p = 0;
            try{
                length = in.read(buffer);
            }catch(Exception e){
                e.printStackTrace();
            }
            if(length == 0) return false;
        }
        return true;
    }
    private int readByte() {
        if (hasNextByte() == true) return buffer[p++];
        return -1;
    }
    private static boolean isPrintable(int n) {
        return 33 <= n && n <= 126;
    }
    private void skip() {
        while (hasNextByte() && !isPrintable(buffer[p])) p++;
    }
    public boolean hasNext() {
        skip();
        return hasNextByte();
    }
    public String next() {
        if(!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int temp = readByte();
        while (isPrintable(temp)) {
            sb.appendCodePoint(temp);
            temp = readByte();
        }
        return sb.toString();
    }
    public int nextInt() {
        return Math.toIntExact(nextLong());
    }
    public int[] nextInts(int n) {
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = nextInt();
        return ar;
    }
    public long[] nextLongs(int n) {
        long[] ar = new long[n];
        for (int i = 0; i < n; i++) ar[i] = nextLong();
        return ar;
    }
    public long nextLong() {
        if(!hasNext()) throw new NoSuchElementException();
        boolean minus = false;
        int temp = readByte();
        if (temp == '-') {
            minus = true;
            temp = readByte();
        }
        if (temp < '0' || '9' < temp) throw new NumberFormatException();
        long n = 0;
        while (isPrintable(temp)) {
            if ('0' <= temp && temp <= '9') {
                n *= 10;
                n += temp - '0';
            }
            temp = readByte();
        }
        return minus ? -n : n;
    }
}
