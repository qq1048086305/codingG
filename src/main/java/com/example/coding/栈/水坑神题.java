package com.example.coding.栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

/**
 * @Author 神様だよ
 * @Date 2021/11/4 22:35
 * @Version 1.0
 * @description:
 */
public class 水坑神题 {
    /**
     * 这道题主要是对栈这种数据结构进行应用，我们使用java中的集合类ArrayDeque来实现。
     *
     * 首先，我们先求总面积。对输入的每个字符进行检查，当碰到""时，
     * 我们将其压入栈（压入栈的是其对应的位置）；当碰到"_"时，不做任何处理；
     * 当碰到"/"时，检查栈是否为空，不为空就说明有对应的"/"，弹出栈顶元素，
     * 用当前的位置减去弹出的栈顶元素，累加这些差值就是最后的面积了。
     *
     * 然后，对于每一个积水处的面积，我们也使用了栈
     * ，栈中存放的对象为两个元素组合的类，两个元素分别为位置和面积。
     * 位置定义为某个积水处的起始处，面积定义为这个积水处的面积。
     * 因为我们是从前向后遍历字符，所以每个积水处的面积不能一下子求出来，
     * 为此我们采取的措施为先将目前已知的积水处压入栈，对于下一个要压入栈的积水处，
     * 检查已压入栈的元素是否包含在这个要压入的积水处，如果包含，则将积水处合并，
     * 如果不包含，则直接压入栈即可。
     *
     * 参考代码如下：
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Stack<Integer> S1=new Stack<>();
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        Stack<Pair >S2=new Stack<>();
        String s;
        int i = 0, sum = 0;
        s=sc.readLine();
        while (i<s.length()) {
            // 若是\则压入栈
            if (s.charAt(i) == '\\')
                S1.push(i);
            else if (s.charAt(i) == '/' && !S1.empty()) {
                int j = S1.pop();
                // 加上新形成的面积
                sum += i - j;
                int a = i - j;

                // 同一块的合在一起
                while (!S2.empty() && S2.peek().fromIndex > j) {
                    a += S2.pop().area;
                }
                //向s2加入当前区域所在初始下标与面积
                S2.push(new Pair(j, a));
            }
            i++;
        }

        Vector<Integer> ans=new Vector<>();
        //遍历一遍s2把pair中的面积加进去
        while (!S2.empty()) {
            ans.add(S2.pop().area);
        }
        //输出总面积
        System.out.println(sum);
        //
        int len = ans.size();
        System.out.print(len);
        for (int j = len - 1; j >= 0; j--) {
            System.out.printf(" %d",ans.get(j));
        }
        System.out.println();
    }
    static class Pair{
        int fromIndex;
        int area;

        public Pair(int fromIndex, int area) {
            this.fromIndex = fromIndex;
            this.area = area;
        }
    }

}
