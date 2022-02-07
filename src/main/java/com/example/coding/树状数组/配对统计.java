package com.example.coding.树状数组;

import com.example.coding.图树.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/20 9:40
 * @Version 1.0
 * @description:
 */
public class 配对统计 {
    //https://www.luogu.com.cn/blog/zhangrui1/solution-p5677
    static int lowbit(int x){	return x & (-x);}
    static int n,m;
    static long tree[]=new long[300001];
    static void add(int pos){	//单点修改（每次只用加1）
        while(pos<=n)
            {tree[pos]++;
            pos+=lowbit(pos);
            }
    }
    static long Query(int num){
        long sum=0;
        while(num>0)
            {sum+=tree[num];num-=lowbit(num);}
        return sum;
    }
    //以上为树状数组的单点修改区间查询

   static class Num implements Comparable<Num>{
        long num;	int pos;	//原数组

        @Override
        public int compareTo(Num o) {
            return (int)(this.num-o.num);
        }
    }
    static Num a[]=new Num[300001];
    static class Pair implements Comparable<Pair>{
        int l,r;			//好对

        @Override
        public int compareTo(Pair o) {
            if(this.r!=o.r){
                return this.r-o.r;
            }else{
                return this.l-o.l;
            }
        }
    }
    static Pair pairr[]=new Pair[600002];
    static int paircnt=0;		//记录好对个数
    static void add_pair(Num a1,Num a2){
        int l=Math.min(a1.pos,a2.pos) , r=Math.max(a1.pos,a2.pos);
        //为了方便查询，统一把好对中出现位置较小的那个放在前面
        pairr[++paircnt]=new Pair();
        pairr[paircnt].l=l;
        pairr[paircnt].r=r;
        return ;
    }
    static class  Questions implements Comparable<Questions>{
        int l,r,pos;		//询问
        @Override
        public int compareTo(Questions o) {
            if(this.r!=o.r){
                return this.r-o.r;
            }else{
                return this.l-o.l;
            }
        }
    }
    static Questions question[]=new Questions[300001];
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String[] s = sc.readLine().split(" ");
        n=Integer.parseInt(s[0]);
        m=Integer.parseInt(s[1]);
        PrintWriter out=new PrintWriter(System.out);
        if(n==1){out.print("0");out.flush();return ;}//新增的hack
        s=sc.readLine().split(" ");
        for(int i=1 ; i<=n ; i++){
            a[i]=new Num();
            a[i].num=Long.parseLong(s[i-1]);
            a[i].pos=i;			//记录下该数在原先序列里的位置，排完序后方便添加配对
        }
        Arrays.sort(a,1,n+1);	//排序
        add_pair(a[1],a[2]);	//首位特殊处理
        add_pair(a[n],a[n-1]);	//末尾特殊处理
        for(int i=2 ; i<n ; i++){
            long ldif = a[i].num-a[i-1].num;
            long rdif = a[i+1].num-a[i].num;	//左边的差 和 右边的差
            if(ldif<rdif)		add_pair(a[i],a[i-1]);		//左边差更小，只有左边的一对
            else if(ldif==rdif)	{add_pair(a[i],a[i-1]);add_pair(a[i],a[i+1]);}
                //两边差更小，有两对
            else				add_pair(a[i],a[i+1]);		//右边差更小，只有右边的一对
        }
        Arrays.sort(pairr , 1 , paircnt+1);	//对所有的好对按右端点从小到大排序
        for(int i=1;i<=m;i++){
            s=sc.readLine().split(" ");
            question[i]=new Questions();
            question[i].l=Integer.parseInt(s[0]);
            question[i].r=Integer.parseInt(s[1]);
            question[i].pos=i;
        }
        Arrays.sort(question,1 , 1+m );//对所有的询问按右端点从小到大排序
        long ans=0;		//ans为最终答案
        for(int i=1,j=1 ; i<=m ; i++){	//i为当前询问，j为当前待入树状数组的好对
            while( j<=paircnt&&pairr[j].r<=question[i].r ){
                add(pairr[j].l);		//如果当前好对的右端点在当前询问的右端点内，就加入树状数组
                j++;
            }
            ans+=1l * question[i].pos * (j-1- Query(question[i].l-1) );	//计算答案
        }
        out.printf("%d",ans);	//输出
        out.flush();
    }
}
