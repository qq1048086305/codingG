package com.example.coding.线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/8 15:54
 * @Version 1.0
 * @description:
 */
public class RMQRUQ {
    static int maxn =100005;
    static int INF = 2147483647;
    static int n, m, s, t,q;
    static int mod=(int)(1e7+5);
    static int ans;
    static int arr[]=new int[maxn];
    static class Node
    {   int l, r;
        long sum;
        //		int laz;
        int tag;//相反数的tag
        long maxx;
        long minn;
        int num;
        int mul;
        int add=-1001;//区间替换用这个
        //int add=0;
        public Node(int l, int r, int minn) {
            this.l = l;
            this.r = r;
            this.minn= minn;
        }
    }
    static class SegmentTree
    {

        Node tr[]=new Node[maxn<<4];
        //Node tr[]=new Node[500];
        //maxn*4
        //更新最大值求和的pushup
        void pushup(int p)
        {
            Node l = tr[p << 1];
            Node r = tr[p << 1 | 1];
            Node rt = tr[p];
            rt.sum = l.sum + r.sum;
            rt.maxx = Math.max(l.maxx, r.maxx);
            rt.minn = Math.min(l.minn, r.minn);
            //rt.num=l.num + r.num;
            int a=0;
        }
        //替换一段区间值的 pushup 告诉自己父节点自己更新了
        void pushup2(int p)
        {
            Node l = tr[p << 1];
            Node r = tr[p << 1 | 1];
            Node rt = tr[p];
            rt.sum = l.sum+r.sum;
            rt.maxx = Math.max(l.maxx, r.maxx);
            rt.minn = Math.min(l.minn, r.minn);
            int a=0;
        }
        void pushup3(int p)
        {
            Node l = tr[p << 1];
            Node r = tr[p << 1 | 1];
            Node rt = tr[p];
            //rt.sum = l.sum;
            rt.maxx = Math.max(l.maxx, r.maxx);
            rt.minn = Math.min(l.minn, r.minn);
            int a=0;
        }

        /**
         * 处理负数问题的pushdown
         * @param p
         */
        void pushdown(int p)
        {
            Node l = tr[p << 1], r = tr[p << 1 | 1], rt = tr[p];
            if(rt.tag == 0) return ;
            l.tag ^= 1;
            r.tag ^= 1;
            l.sum = -l.sum;
            r.sum = -r.sum;
            l.maxx = -l.maxx;
            r.maxx = -r.maxx;
            l.minn = -l.minn;
            r.minn = -r.minn;
            swap(l.maxx, l.minn,l);
            swap(r.maxx, r.minn,r);
            rt.tag = 0;
        }

        /**
         * 交换最大最小值得函数
         * @param maxx
         * @param minn
         * @param x
         */
        private void swap(long maxx, long minn, Node x) {
            long tmp=maxx;
            x.maxx=minn;
            x.minn=tmp;
        }
        //树的初始化
        void build(int p, int l, int r)
        {
            tr[p] = new Node(l, r, INF);
            tr[p].mul=1;
            if(l == r) {
                tr[p].sum = tr[p].minn = tr[p].maxx =tr[p].num= arr[l];
                //tr[p].add=0;
                return ;
            }
            int mid = l + r >> 1;
            build(2*p, l, mid);
            build(2*p+1, mid + 1, r);
            pushup(p);
        }
        //单点修改为k
        void modify(int p, int x, int k)
        {
            if(tr[p].l == tr[p].r) {
                tr[p].sum = tr[p].minn = tr[p].maxx = k;
                return ;
            }
            if(tr[p].tag>0) pushdown(p);
            int mid = tr[p].l + tr[p].r >> 1;
            if(x <= mid) modify(p << 1, x, k);
            if(x > mid) modify(p << 1 | 1, x, k);
            pushup(p);
        }
        //区间负数逆转
        void _reverse(int p, int l, int r)
        {
            if(tr[p].l >= l && tr[p].r <= r) {
                tr[p].tag ^= 1;
                tr[p].sum = -tr[p].sum;
                tr[p].minn = -tr[p].minn;
                tr[p].maxx = -tr[p].maxx;
                swap(tr[p].minn, tr[p].maxx,tr[p]);
                return ;
            }
            if(tr[p].tag>0) pushdown(p);
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) _reverse(p << 1, l, r);
            if(r > mid) _reverse(p << 1 | 1, l, r);
            pushup(p);
        }
        //查询区间和函数
        long query_sum(int p, int l, int r)
        {   //声明答案
            long res = 0;
            if(tr[p].l >= l && tr[p].r <= r) return tr[p].sum;
            if(tr[p].tag>0) pushdown(p);
            push_down2(p);
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) res += query_sum(p << 1, l, r);
            if(r > mid) res += query_sum(p << 1 | 1, l, r);
            pushup(p);
            return res;
        }
        //查询区间和函数 根据区间替换后
        long query_sum_replace(int p, int l, int r)
        {   //声明答案
            long res = 0;
            if(tr[p].l >= l && tr[p].r <= r) return tr[p].sum;
            if(tr[p].tag>0) pushdown(p);
            push_down_replace(p);
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) res += query_sum_replace(p << 1, l, r);
            if(r > mid) res += query_sum_replace(p << 1 | 1, l, r);
            pushup(p);
            return res;
        }
        //单点查询一个值(针对区间替换)
        long queryOne(int p,int x)//单点查询，查询第x个元素的值
        {
            if(tr[p].l==tr[p].r)
            {
                return tr[p].num;
            }
            int mid=(tr[p].l+tr[p].r)>>1;
            push_down_replace(p);
            if(x<=mid)
                return queryOne(p<<1,x);
                //if(R>mid)
            else
                return queryOne(p<<1|1,x);
        }
        //单点查询一个值(针对乘法加法)
        long queryOne2(int p,int x)//单点查询，查询第x个元素的值
        {
            if(tr[p].l==tr[p].r)
            {
                return tr[p].num;
            }
            int mid=(tr[p].l+tr[p].r)>>1;
            push_down2(p);
            if(x<=mid)
                return queryOne2(p<<1,x);
                //if(R>mid)
            else
                return queryOne2(p<<1|1,x);
        }
        //
        long query_sum2(int p, int l, int r)
        {
            long res = 0;
            if(tr[p].l >= l && tr[p].r <= r) return tr[p].sum;
            if(tr[p].tag>0) pushdown(p);
            //push_down(p);
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) res = query_sum2(p << 1, l, r);
            if(r > mid) res = query_sum2(p << 1 | 1, l, r);
            pushup(p);
            return res;
        }
        //查询一段区间最大值
        long query_max(int p, int l, int r)
        {
            long res = -INF;
            if(tr[p].l >= l && tr[p].r <= r) return tr[p].maxx;
            if(tr[p].tag>0) pushdown(p);
            int mid = tr[p].l + tr[p].r >> 1;
            push_down2(p);
            if(l <= mid) res = Math.max(res, query_max(p << 1, l, r));
            if(r > mid) res = Math.max(res, query_max(p << 1 | 1, l, r));
            pushup(p);
            return res;
        }
        //查询一段区间最小值
        long query_min(int p, int l, int r)
        {
            long res = INF;
            if(tr[p].l >= l && tr[p].r <= r) return tr[p].minn;
            if(tr[p].tag>0) pushdown(p);
            push_down2(p);
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) res = Math.min(res, query_min(p << 1, l, r));
            if(r > mid) res = Math.min(res, query_min(p << 1 | 1, l, r));
            pushup(p);
            return res;
        }
        //查询一段区间最小值根据替换后的区间
        long query_min_replace(int p, int l, int r)
        {
            long res = INF;
            if(tr[p].l >= l && tr[p].r <= r) return tr[p].minn;
            if(tr[p].tag>0) pushdown(p);
            push_down_replace(p);//更新子状态 如果懒标记存在
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) res = Math.min(res, query_min_replace(p << 1, l, r));
            if(r > mid) res = Math.min(res, query_min_replace(p << 1 | 1, l, r));
            pushup2(p);
            return res;
        }
        //区间修改

        /**
         * 区间修改、区间查询，你可能会认为，把上一章里面的这两个模块加在一起就好了，然后你就会发现你大错特错。
         *
         * 因为如果对于1~4这个区间，你把1~3区间+1，相当于把节点1~2和3标记，但是如果你查询2~4时，你会发现你加的时没有标记的2节点和没有标记的3~4节点加上去，结果当然是错的。
         *
         * 那么我们应该怎么办？这时候pushdown的作用就显现出来了。
         *
         * 你会想到，我们只需要在查询的时候，如果我们要查的2节点在1~2区间的里面，那我们就可以把1~2区间标记的那个+1给推下去这样就能顺利地加上了。
         * 怎么记录这个标记呢？我们需要记录一个“懒标记”lazytage，来记录这个区间
         */
        /**
         * 1、如果当前区间被完全覆盖在目标区间里，讲这个区间的sum+k*(tree[p].r-tree[p].l+1)
         *
         * 2、如果没有完全覆盖，则先下传懒标记
         *
         * 3、如果这个区间的左儿子和目标区间有交集，那么搜索左儿子
         *
         * 4、如果这个区间的右儿子和目标区间有交集，那么搜索右儿子
         */
        //区间修改+k
        void modifyRange(int p,int l,int r,int k)//区间+k
        {
            if(tr[p].r<=r && tr[p].l>=l)//如果当前区间被完全覆盖在目标区间里，讲这个区间的sum+k*(tree[p].r-tree[p].l+1)
            {   //tr[p].add+=k;//防止与区间替换冲突
                tr[p].sum+=k*(tr[p].r-tr[p].l+1);
                tr[p].add+=k;//记录lazytage
                tr[p].maxx+=k;
                tr[p].minn+=k;
                tr[p].num+=k;
                return ;
            }
            push_down2(p);//向下传递
            if(tr[p*2].r>=l)
                modifyRange(p*2,l,r,k);
            if(tr[p*2+1].l<=r)
                modifyRange(p*2+1,l,r,k);
            pushup(p);
            return ;
        }
        //区间替换为k
        void replaceRange(int p,int l,int r,int k)//区间=k
        {
            if(tr[p].r<=r && tr[p].l>=l)
                //如果当前区间被完全覆盖在目标区间里，讲这个区间的sum+k*(tree[p].r-tree[p].l+1)
            {
                tr[p].num=k;
                tr[p].add=k;//记录lazytage
                tr[p].maxx=k;
                tr[p].minn=k;
                //维护一个sum
                tr[p].sum=k*(tr[p].r-tr[p].l+1);
                return;
            }
            push_down_replace(p);//向下传递
            if(tr[p*2].r>=l)
                replaceRange(p*2,l,r,k);
            if(tr[p*2+1].l<=r)
                replaceRange(p*2+1,l,r,k);
            pushup2(p);
            return ;
        }
        //区间乘法
        void mult(int p,int l,int r,int k)
        {
            if(tr[p].l>=l&&tr[p].r<=r)
            {
                tr[p].mul=(tr[p].mul*k)%mod;
                tr[p].add=(tr[p].add*k)%mod;
                tr[p].sum=(tr[p].sum*k)%mod;
                tr[p].maxx=(tr[p].maxx*k)%mod;
                tr[p].minn=(tr[p].minn*k)%mod;
                return ;
            }
            push_down_replace(p);
            tr[p].sum=(tr[p*2].sum+tr[p*2+1].sum)%mod;
            if(tr[p*2].r>=l)
                mult(p*2,l,r,k);
            if(tr[p*2+1].l<=r)
                mult(p*2+1,l,r,k);
            //ll mid=(tree[p].l+tree[p].r)>>1;
            //if(l<=mid)mult(p*2,l,r,k);
            //if(mid<r)mult(p*2+1,l,r,k);
            pushup(p);
        }
        //要记住当前状态是父亲的子区间 父亲更新过了 自己应该变成父亲的状态不要用Math再比较了，那是错误的
        //比如父亲[2,7] 自己是[3,4]父亲被换掉了值自己也相当于换掉了
        //区间替换对应 push down函数
        void push_down_replace(int i)
        {
            if(tr[i].add!=-1001)//这个地方如果替换的时候是0判断条件不成立会导致0替换失败
            {
                tr[i*2].add=tr[i].add;//左右儿子分别加上父亲的lz
                tr[i*2+1].add=tr[i].add;
                int mid=(tr[i].l+tr[i].r)/2;
                tr[i*2].num=tr[i].num;//左右分别求和加起来
                tr[i*2+1].num=tr[i].num;
                //最小值需要更新 如果是替换的话
                tr[i*2].minn=tr[i].minn;
                tr[i*2+1].minn=tr[i].minn;
                tr[i*2].maxx=tr[i].maxx;
                tr[i*2+1].maxx=tr[i].maxx;
                tr[i*2].sum=tr[i].add*(tr[i*2].r-tr[i*2].l+1);
                tr[i*2+1].sum=tr[i].add*(tr[i*2+1].r-tr[i*2+1].l+1);
                tr[i].add=-1001;//父亲lz归零,由于初始值为-1所以变为-1
            }
            return ;
        }
        //加法区间处理
        void push_down2(int i)
        {
            if(tr[i].add!=0){
                tr[i*2].num+=tr[i].add;
                tr[i*2+1].num+=tr[i].add;
                //tr[i*2].sum=(long)(tr[i].mul*tr[i*2].sum+((tr[i*2].r-tr[i*2].l+1)*tr[i].add)%mod)%mod;
                //tr[i*2+1].sum=(long)(tr[i].mul*tr[i*2+1].sum+((tr[i*2+1].r-tr[i*2+1].l+1)*tr[i].add)%mod)%mod;
                tr[i*2].mul=(tr[i*2].mul*tr[i].mul)%mod;
                tr[i*2+1].mul=(tr[i*2+1].mul*tr[i].mul)%mod;
                //tr[i*2].add=(tr[i*2].add*tr[i].mul+tr[i].add)%mod;
                //tr[i*2+1].add=(tr[i*2+1].add*tr[i].mul+tr[i].add)%mod;
                tr[i*2].sum+=tr[i].add;
                tr[i*2+1].sum+=tr[i].add;
                tr[i].mul=1;tr[i].add=0;//初始化-1
            }
               /* if(tr[i].add!=0)
                {
                    tr[i*2].add+=tr[i].add;//左右儿子分别加上父亲的lz
                    tr[i*2+1].add+=tr[i].add;
                    int mid=(tr[i].l+tr[i].r)/2;
                    tr[i*2].sum+=tr[i].add*(mid-tr[i*2].l+1);//左右分别求和加起来
                    tr[i*2+1].sum+=tr[i].add*(tr[i*2+1].r-mid);
                    tr[i].add=0;//父亲lz归零
                }*/

            return ;
        }
        //乘法区间处理
        void push_down_mutiple(int i)
        {
            if(tr[i].add!=0){
                tr[i*2].num+=tr[i].add;
                tr[i*2+1].num+=tr[i].add;
                tr[i*2].sum=(long)(tr[i].mul*tr[i*2].sum+((tr[i*2].r-tr[i*2].l+1)*tr[i].add)%mod)%mod;
                tr[i*2+1].sum=(long)(tr[i].mul*tr[i*2+1].sum+((tr[i*2+1].r-tr[i*2+1].l+1)*tr[i].add)%mod)%mod;
                tr[i*2+1].maxx=(long)(tr[i].mul*tr[i*2+1].maxx+((tr[i*2+1].r-tr[i*2+1].l+1)*tr[i].add)%mod)%mod;
                tr[i*2+1].minn=(long)(tr[i].mul*tr[i*2+1].minn+((tr[i*2+1].r-tr[i*2+1].l+1)*tr[i].add)%mod)%mod;
                tr[i*2].minn=(long)(tr[i].mul*tr[i*2].minn+((tr[i*2].r-tr[i*2].l+1)*tr[i].add)%mod)%mod;
                tr[i*2].maxx=(long)(tr[i].mul*tr[i*2].maxx+((tr[i*2].r-tr[i*2].l+1)*tr[i].add)%mod)%mod;
                tr[i*2].mul=(tr[i*2].mul*tr[i].mul)%mod;
                tr[i*2+1].mul=(tr[i*2+1].mul*tr[i].mul)%mod;
                tr[i*2].add=(tr[i*2].add*tr[i].mul+tr[i].add)%mod;
                tr[i*2+1].add=(tr[i*2+1].add*tr[i].mul+tr[i].add)%mod;
                //tr[i*2].add+=tr[i].add;
                //tr[i*2+1].add+=tr[i].add;
                tr[i].mul=1;tr[i].add=0;//初始化-1
            }
               /* if(tr[i].add!=0)
                {
                    tr[i*2].add+=tr[i].add;//左右儿子分别加上父亲的lz
                    tr[i*2+1].add+=tr[i].add;
                    int mid=(tr[i].l+tr[i].r)/2;
                    tr[i*2].sum+=tr[i].add*(mid-tr[i*2].l+1);//左右分别求和加起来
                    tr[i*2+1].sum+=tr[i].add*(tr[i*2+1].r-mid);
                    tr[i].add=0;//父亲lz归零
                }*/

            return ;
        }
        long search(int i,int l,int r)
        {
            if(tr[i].l>=l && tr[i].r<=r)
                return tr[i].sum;
            if(tr[i].r<l || tr[i].l>r)  return 0;
            //push_down(i);
            int s=0;
            if(tr[i*2].r>=l)  s+=search(i*2,l,r);
            if(tr[i*2+1].l<=r)  s+=search(i*2+1,l,r);
            return s;
        }
        //开根号
        void change(int i,int l,int r)
        {
            if(tr[i].l==tr[i].r)
            {
                //tr[i].sum=Math.sqrt(tr[i].sum);
                //tr[i].maxx=Math.sqrt(tr[i].maxx);
                return ;
            }
            if(tr[i*2].r>=l&&tr[i*2].maxx>1)
                change(i*2,l,r);
            if(tr[i*2+1].l<=r&&tr[i*2+1].maxx>1)
                change(i*2+1,l,r);
            pushup(i);
        }
    }

    public static void main(String[] args) throws IOException {
       /*SegmentTree segmentTree=new SegmentTree();
        Arrays.fill(arr,8);
        segmentTree.build(1,1,10);
       //segmentTree.modifyRange(1,2,5,5);
        System.out.println(segmentTree.query_min(1,2,5));
        System.out.println(segmentTree.query_max(1,2,5));
        //segmentTree.mult(1,2,5,2);
        segmentTree.modifyRange(1,2,5,-5);
        segmentTree.mult(1,2,5,2);
        System.out.println(segmentTree.query_sum(1,2,5));
        System.out.println(segmentTree.query_min(1,2,5));
        System.out.println(segmentTree.query_max(1,2,5));*/
        SegmentTree segmentTree=new SegmentTree();
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        String[] split = sc.readLine().split("\\s+");
        n=Integer.parseInt(split[0]);
        q=Integer.parseInt(split[1]);
        //Arrays.fill(arr,2147483647);
        segmentTree.build(1,1,n);
        for(int i=0;i<q;i++){
            String[] s = sc.readLine().split("\\s+");
            int a,b,c,d;
            a=Integer.parseInt(s[0]);
            b=Integer.parseInt(s[1]);
            //c=Integer.parseInt(s[2]);
            if(a==0){
                c=Integer.parseInt(s[2]);
                d=Integer.parseInt(s[3]);
                segmentTree.replaceRange(1,b+1,c+1,d);
                //segmentTree.modifyRange(1,b,c,d);
            }else if(a==1){
                c=Integer.parseInt(s[2]);
                System.out.println(segmentTree.query_sum_replace(1,b+1,c+1));
                //System.out.println(segmentTree.query_min_replace(1,b+1,c+1));
                //System.out.println(segmentTree.queryOne2(1,b));
            }
        }
       /* for(int i=0;i<q;i++){
            String[] s = sc.readLine().split("\\s+");
            int a,b,c;
            a=Integer.parseInt(s[0]);
            b=Integer.parseInt(s[1]);
            c=Integer.parseInt(s[2]);
            if(a==0){
                arr[b]=arr[b]+c;
                segmentTree.modify(1,b,arr[b]);
            }else if(a==1){
                //System.out.println(segmentTree.query_min(1,b+1,c+1));
                System.out.println(segmentTree.query_sum(1,b,c));
            }
        }*/
        //segmentTree.modifyRange(1,2,4,10);
        //segmentTree.query_sum(1,2,4);
        //segmentTree._reverse(1,2,4);
        //segmentTree._reverse(1,2,4);
        //System.out.println(segmentTree.query_sum(1,3,5));
    }
}
