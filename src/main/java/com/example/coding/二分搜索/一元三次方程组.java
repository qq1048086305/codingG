package com.example.coding.二分搜索;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/13 9:37
 * @Version 1.0
 * @description:
 */

/**
 * 发现一个长度为1的区间至多一个解 每次枚举1个长度为3区间 过程中根据函数值条件判断使用二分来找出答案
 */
public class 一元三次方程组 {
    static double a,b,c,d;
    //函数计算
    static double fc(double x)
    {
        return a*x*x*x+b*x*x+c*x+d;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double l,r,m,x1,x2;
        int s=0,i;
        a=sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();
        d=sc.nextDouble();
        for (i=-100;i<100;i++)
        //(-100,100) 范围内二分出 x根的3个答案
        {   //三个答案都在[-100,100]范围内，两个根的差的绝对值>=1,
            // 保证了每一个大小为1的区间里至多有1个解，也就是说当区间的两个端点的函数值异号时区间内一定有一个解，
            // 同号时一定没有解。
            // 那么我们可以枚举互相不重叠的每一个长度为1的区间，在区间内进行二分查找。
            l=i;
            r=i+1;
            x1=fc(l);
            x2=fc(r);
            if(x1==0)
            {
                System.out.printf("%.2f ",l);
                s++;
            }      //判断左端点，是零点直接输出。
            //不能判断右端点，会重复。
            if(x1*x2<0)                              //区间内有根。
            {   //精度二分
                while(r-l>=0.001)                     //二分控制精度。
                {
                    m=(l+r)/2;  //middle
                    if(fc(m)*fc(r)<=0)
                        l=m;
                    else
                        r=m;   //计算中点处函数值缩小区间。
                }
                System.out.printf("%.2f ",l);
                //输出右端点。
                s++;
            }
            if (s==3)
                break;
            //找到三个就退出大概会省一点时间
        }
    }

}
