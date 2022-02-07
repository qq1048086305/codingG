package com.example.coding.滑动窗口;


import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * @Author 神様だよ
 * @Date 2021/11/9 12:57
 * @Version 1.0
 * @description:
 */
@SuppressWarnings("unchecked")
public class 长度为k最小值滑动窗口 {
    static final int INF = 1<<30;
    static final long INFL = 1L<<60;
    static final int MOD = 1000000007;
    static final int MOD2 = 998244353;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        //双端队列维护队首是最大值 每次元素都丢到队尾 每次都判断队首是不是过期
        LinkedList<Integer> q = new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        int n = sc.nextInt();
        int l = sc.nextInt();
        int a[]=new int [n+1];
        for(int i=1;i<=n;i++){
            a[i]=sc.nextInt();
        }
        for(int i=1;i<=n;i++){
            //保持队列的递减性
            while(!q.isEmpty()&&q.peek()<=i-l){//这边不能等于 因为这是加入之前的判断 = 的话相当于过滤了一个没有过期的元素
                q.pollFirst();
            }
            while(!q.isEmpty()&&a[q.peekLast()]>a[i]){
                q.pollLast();
            }
            q.addLast(i);
            //第二规则，判断队首是否不在当前窗口，如果是，删除队首(i-k就是左指针)
            //当前窗口已经形成，保存队首作为当前窗口最大值
            if(i-l>=0){
                ans.add(a[q.peekFirst()]);
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if(i!=ans.size()-1){
                out.print(ans.get(i)+ " ");
            }else{
                out.println(ans.get(i));
            }
        }
        out.close();
    }
}
class Pair implements Comparable<Pair>{
    int idx, val;
    Pair(int idx, int val){
        this.idx = idx;
        this.val = val;
    }
    @Override
    public int compareTo(Pair another){
        return this.val - another.val;
    }
}
class FastScanner {
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

