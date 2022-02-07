package com.example.coding.有序表的使用;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author 神様だよ
 * @Date 2021/11/7 18:38
 * @Version 1.0
 * @description:
 */
public class TreeSet和HashSet {
    //TreeSet和HashSet 区别在于底层数据结构 和 多了一个有序 null值的是否允许
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int q=scan.nextInt();
        TreeSet<Integer> st=new TreeSet<Integer>();
        for(int i=0;i<q;i++){
            int type=scan.nextInt();
            if(type==0){
                int x=scan.nextInt();
                st.add(x);
                System.out.println(st.size());
            }
            else if(type==1){
                int x=scan.nextInt();
                if(st.contains(x))System.out.println(1);
                else System.out.println(0);
            }
            else if(type==2){
                int x=scan.nextInt();
                if(st.contains(x)){
                    st.remove(x);
                }
            }
            else{
                int l=scan.nextInt();
                int r=scan.nextInt();
                int cur=l;
                while(true){
                    if(st.ceiling(cur)!=null){
                        //找到大于等于cur的元素 每次cur+1往后找直到大于r
                        int nex=st.ceiling(cur);
                        if(nex>r)break;
                        System.out.println(nex);
                        cur=nex+1;
                    }
                    else break;
                }
            }
        }
        scan.close();
    }
}
