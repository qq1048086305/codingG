package com.example.coding.计算几何;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * @Author 神様だよ
 * @Date 2021/11/10 12:05
 * @Version 1.0
 * @description:
 */
public class 投影 {
    //求一个点在一条线上投影的坐标
    static final int INF = 1000000000;
    static final long MOD = 1000000007;
    static final double EPS = 1e-10;

    public static void main(String args[]) throws IOException {
        IO io = new IO();
        int n=io.getInt();
        /*int arr[] = io.getIntArrPrim();
        Point p0=new Point(arr[0],arr[1]);
        Point p1=new Point(arr[2],arr[3]);*/
        //LineSegment l = new LineSegment(new Point(arr[0], arr[1]), new Point(arr[2], arr[3]));
        //Vector p0p1=new Vector(p1.x-p0.x,p1.y-p0.y);
        //int q = io.getInt();

        Geometry g = new Geometry();
        //判断两个直线平行垂直
        /*for (int i = 0; i <n ; i++) {
            int arr[] = io.getIntArrPrim();
            Point p0=new Point(arr[0],arr[1]);
            Point p1=new Point(arr[2],arr[3]);
            Point p2=new Point(arr[4],arr[5]);
            Point p3=new Point(arr[6],arr[7]);
            Vector p0p1=new Vector(p1.x-p0.x,p1.y-p0.y);
            Vector p2p3=new Vector(p3.x-p2.x,p3.y-p2.y);
            if(g.isParallel(p0p1,p2p3)){
                System.out.println("2");
            }else if(g.isOrthogonal(p0p1,p2p3)){
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }*/
        /*//求投影点坐标
        for (int i = 0; i < q; i++) {
            arr = io.getIntArrPrim();

            Point p = new Point(arr[0], arr[1]);

            Point pro = g.project(l, p);

            System.out.println(pro.x + " " + pro.y);
        }*/
        //求关于一条直线对称点坐标
        /*for (int i = 0; i < q; i++) {
            arr = io.getIntArrPrim();

            Point p = new Point(arr[0], arr[1]);

            Point pro = g.project(l, p);
            Point target=g.midPointGoOther(pro,p);
            System.out.println(target.x + " " + target.y);
        }*/
        //判断两条向量之间的关系
        /*for (int i = 0; i < q; i++) {
            arr = io.getIntArrPrim();
            Point p2 = new Point(arr[0], arr[1]);
            Vector p0p2=new Vector(p2.x-p0.x,p2.y-p0.y);
            String ans="";
            int iAns=g.ccw(p0p1,p0p2);
            switch (iAns) {
                case Geometry.COUNTER_CLOCKWISE: ans = "COUNTER_CLOCKWISE";break;
                case Geometry.CLOCKWISE: ans = "CLOCKWISE";break;
                case Geometry.ONLINE_BACK: ans = "ONLINE_BACK";break;
                case Geometry.ONLINE_FRONT: ans = "ONLINE_FRONT";break;
                case Geometry.ON_SEGMENT: ans = "ON_SEGMENT";break;
                default:break;
            }
            System.out.println(ans);
        }*/
        //相交判定
        for (int i = 0; i <n ; i++) {
            int arr[] = io.getIntArrPrim();
            Point p0=new Point(arr[0],arr[1]);
            Point p1=new Point(arr[2],arr[3]);
            Point p2=new Point(arr[4],arr[5]);
            Point p3=new Point(arr[6],arr[7]);
            Vector p0p1=new Vector(p1.x-p0.x,p1.y-p0.y);
            Vector p2p3=new Vector(p3.x-p2.x,p3.y-p2.y);
            if(g.isParallel(p0p1,p2p3)){
                System.out.println("0");
            }else{
                System.out.println("1");
            }
        }
    }
}
//对边和向量的操作类
class Geometry {
    final double EPS = 1e-10;

    public boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < EPS;
    }
    //模方
    //return x^2+y^2
    public double norm(Vector v) {
        return v.x * v.x + v.y * v.y;
    }
    //模方
    //return x^2+y^2
    public double norm(Point p) {
        return p.x * p.x + p.y * p.y;
    }
    //求角度时候用
    //向量根号下x^2+y^2
    public double abs(Vector v) { // ベクトルの大きさ
        return Math.sqrt(norm(v));
    }
    //求角度时候用
    //向量根号下x^2+y^2
    public double abs(Point p) { // ベクトルの大きさ
        return Math.sqrt(norm(p));
    }
    //向量的x1*x2+y1*y2
    public double dot(Vector a, Vector b) { // 内積
        return a.x * b.x + a.y * b.y;
    }
    //向量的x1*x2+y1*y2
    public double dot(Point a, Point b) { // 内積
        return a.x * b.x + a.y * b.y;
    }
    //向量的x1*y2-x2*y1
    public double cross(Vector a, Vector b) { // 外積
        return a.x * b.y - a.y * b.x;
    }
    //向量的x1*y2-x2*y1
    public double cross(Point a, Point b) { // 外積
        return a.x * b.y - a.y * b.x;
    }
    //判断两个向量是否互相垂直  x1*x2+y1*y2=0
    public boolean isOrthogonal(Vector a, Vector b) { // 直交判定
        return doubleEquals(dot(a, b), 0.0);
    }
    //判断两个边是否垂直 （转化为向量做）x1*x2+y1*y2=0
    public boolean isOrthogonal(LineSegment a, LineSegment b) { // 直交判定
        return doubleEquals(dot(a.p2.diff(a.p1), b.p2.diff(b.p1)), 0.0);
    }
    //两个向量是否平行的判定 外积的判定  x1*y2-x2*y1=0
    public boolean isParallel(Vector a, Vector b) { // 平行判定
        return doubleEquals(cross(a, b), 0.0);
    }
    //两条边的平行判定 转换为向量  外积的判定  x1*y2-x2*y1=0
    public boolean isParallel(LineSegment a, LineSegment b) { // 平行判定
        //
        return doubleEquals(cross(a.p2.diff(a.p1), b.p2.diff(b.p1)), 0.0);
    }
    //投影  一个点对一条边上的投影
    public Point project(LineSegment s, Point p) { // 射影
        //拿到这个线的向量
        Point base = s.p2.diff(s.p1);
        //求这个点和线向量的内积/平方和
        double r = dot(p.diff(s.p1), base) / norm(base);
        return base.multiply(r).add(s.p1);
    }

    //已知三点中的中点和其中一个点求另一个点
    public Point midPointGoOther(Point mid, Point p) { // 射影
        Point newMid=mid.multiply(2);
        return new Point(newMid.x-p.x,newMid.y-p.y);
    }
    //求两个向量之间位置关系
    //p0が始点
    public  int ccw(Vector s1, Vector s2){
        //通过向量外积判断向量位于该向量顺时针还是逆时针
        double cross = cross(s1, s2);//外积
        //内积在共线时候快速判断一下是不是反向
        double dot = dot(s1, s2);//内积
        //如果大于0 s2在 s1的逆时针方向
        if(cross>0){return COUNTER_CLOCKWISE;}
        //如果大于0 s2在 s1的顺时针方向
        if(cross<0){return CLOCKWISE;}
        //等于0共线 用内积判断负方向
        if(dot<0){return ONLINE_BACK;}
        //如果向量s1模小于向量s2模那么就是在前面
        if(s1.abs()<s2.abs()){return ONLINE_FRONT;}
        //否则在中间
        return ON_SEGMENT;
    }
    //做题用常量
    public static final int COUNTER_CLOCKWISE=1;
    public static final int CLOCKWISE=-1;
    public static final int ONLINE_BACK=2;
    public static final int ONLINE_FRONT=-2;
    public static final int ON_SEGMENT=0;
}
//点类 用来两个点之间加减法  单点倍乘法
class Point {
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    //点的横纵坐标互相相加  返回一个新的点(x1+x2 ，y1+y2)
    public Point add(Point p) {
        return new Point(x + p.x, y + p.y);
    }
    //点的横纵坐标互相相减  返回一个新的向量(x1-x2 ，y1-y2)
    public Point diff(Point p) {
        return new Point(x - p.x, y - p.y);
    }
    //返回一个倍乘点  返回一个新的点(x*k ，y*k)
    public Point multiply(double k) {
        return new Point(x * k, y * k);
    }
}
//向量类
class Vector {
    double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    //向量的横纵坐标互相相加  返回一个新的向量(x1+x2 ，y1+y2)
    public Vector add(Vector v) {
        return new Vector(x + v.x, y + v.y);
    }
    //向量的横纵坐标互相相加  返回一个新的向量(x1-x2 ，y1-y2)
    public Vector diff(Vector v) {
        return new Vector(x - v.x, y - v.y);
    }
    //向量的横纵坐标互相相加  返回一个新的向量(x*k ，y*k)
    public Vector multiply(double k) {
        return new Vector(x * k, y * k);
    }

    public void addThis(Vector v) {
        x += v.x;
        y += v.y;
    }

    public void diffThis(Vector v) {
        x -= v.x;
        y -= v.y;
    }

    public void multiplyThis(double k) {
        x *= k;
        y *= k;
    }

    public double norm() {
        return x * x + y * y;
    }

    public double abs() { // ベクトルの大きさ
        return Math.sqrt(norm());
    }

    public double dot(Vector v) { // 内積
        return x * v.x + y * v.y;
    }

    public double cross(Vector v) { // 外積
        return x * v.y - y * v.x;
    }

}

/*class Line {
    Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}*/
//保存两条边的类
class LineSegment {
    Point p1, p2;

    public LineSegment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}

/*class En {
    Point c;
    double r;

    public En(Point c, double r) {
        this.c = c;
        this.r = r;
    }
}

class Polygon {
    ArrayList<Point> p = new ArrayList<>();

    public Polygon() {

    }

    public Polygon(ArrayList<Point> p) {
        this.p = p;
    }
}*/
//输入输出类
class IO {
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

