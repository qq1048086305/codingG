package com.example.coding.线段树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author 神様だよ
 * @Date 2021/11/7 22:55
 * @Version 1.0
 * @description:
 */
//单点修改 区间求和 区间最小最大值 负数处理 区间查询 区间修改
public class RMQ {
    static int maxn =100005;
    static int INF = 2147483647;
    static int n, m, s, t,q;
    static int ans;
    static int arr[]=new int[maxn];
    static class Node
    {   int l, r;
        int sum;
        //		int laz;
        int tag;//相反数的tag
        int maxx;
        int minn;
        int num;
        int mul;
        int lz=0;
        public Node(int l, int r, int minn) {
            this.l = l;
            this.r = r;
            this.minn= minn;
        }
    }
    static class SegmentTree
    {

        Node tr[]=new Node[50];
        //maxn*4
        void pushup(int p)
        {
            Node l = tr[p << 1];
            Node r = tr[p << 1 | 1];
            Node rt = tr[p];
            rt.sum = l.sum + r.sum;
            rt.maxx = Math.max(l.maxx, r.maxx);
            rt.minn = Math.min(l.minn, r.minn);
        }
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

        private void swap(int maxx, int minn,Node x) {
            int tmp=maxx;
            x.maxx=minn;
            x.minn=tmp;
        }
        void build(int p, int l, int r)
        {
            tr[p] = new Node(l, r, INF);
            tr[p].mul=1;
            if(l == r) {
                tr[p].sum = tr[p].minn = tr[p].maxx = arr[l];
                return ;
            }
            int mid = l + r >> 1;
            build(2*p, l, mid);
            build(2*p+1, mid + 1, r);
            pushup(p);
        }
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
        int query_sum(int p, int l, int r)
        {
            int res = 0;
            if(tr[p].l >= l && tr[p].r <= r) return tr[p].sum;
            if(tr[p].tag>0) pushdown(p);
            push_down(p);
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) res += query_sum(p << 1, l, r);
            if(r > mid) res += query_sum(p << 1 | 1, l, r);
            pushup(p);
            return res;
        }
        int query_max(int p, int l, int r)
        {
            int res = -INF;
            if(tr[p].l >= l && tr[p].r <= r) return tr[p].maxx;
            if(tr[p].tag>0) pushdown(p);
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) res = Math.max(res, query_max(p << 1, l, r));
            if(r > mid) res = Math.max(res, query_max(p << 1 | 1, l, r));
            pushup(p);
            return res;
        }
        int query_min(int p, int l, int r)
        {
            int res = INF;
            if(tr[p].l >= l && tr[p].r <= r) return tr[p].minn;
            if(tr[p].tag>0) pushdown(p);
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) res = Math.min(res, query_min(p << 1, l, r));
            if(r > mid) res = Math.min(res, query_min(p << 1 | 1, l, r));
            pushup(p);
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
         * 1、如果当前区间被完全覆盖在目标区间里，讲这个区间的sum+k*(tree[i].r-tree[i].l+1)
         *
         * 2、如果没有完全覆盖，则先下传懒标记
         *
         * 3、如果这个区间的左儿子和目标区间有交集，那么搜索左儿子
         *
         * 4、如果这个区间的右儿子和目标区间有交集，那么搜索右儿子
         */
        //区间修改
        void modifyRange(int i,int l,int r,int k)//区间+k
        {
            if(tr[i].r<=r && tr[i].l>=l)//如果当前区间被完全覆盖在目标区间里，讲这个区间的sum+k*(tree[i].r-tree[i].l+1)
            {
                //tr[i].sum+=k*(tr[i].r-tr[i].l+1);
                //tr[i].lz+=k;//记录lazytage
                return ;
            }
            push_down(i);//向下传递
            if(tr[i*2].r>=l)
                modifyRange(i*2,l,r,k);
            if(tr[i*2+1].l<=r)
                modifyRange(i*2+1,l,r,k);
            tr[i].sum=tr[i*2].sum+tr[i*2+1].sum;
            return ;
        }
        void push_down(int i)
        {
            if(tr[i].lz!=0)
            {
                tr[i*2].lz+=tr[i].lz;//左右儿子分别加上父亲的lz
                tr[i*2+1].lz+=tr[i].lz;
                int mid=(tr[i].l+tr[i].r)/2;
                tr[i*2].sum+=tr[i].lz*(mid-tr[i*2].l+1);//左右分别求和加起来
                tr[i*2+1].sum+=tr[i].lz*(tr[i*2+1].r-mid);
                tr[i].lz=0;//父亲lz归零
            }
            /*tree[i*2].sum=(ll)(tree[i].mul*tree[i*2].sum+((tree[i*2].r-tree[i*2].l+1)*tree[i].add)%mod)%mod;
            tree[i*2+1].sum=(ll)(tree[i].mul*tree[i*2+1].sum+((tree[i*2+1].r-tree[i*2+1].l+1)*tree[i].add)%mod)%mod;
            tree[i*2].mul=(ll)(tree[i*2].mul*tree[i].mul)%mod;
            tree[i*2+1].mul=(ll)(tree[i*2+1].mul*tree[i].mul)%mod;
            tree[i*2].add=(ll)(tree[i*2].add*tree[i].mul+tree[i].add)%mod;
            tree[i*2+1].add=(ll)(tree[i*2+1].add*tree[i].mul+tree[i].add)%mod;
            tree[i].mul=1;tree[i].add=0;*/
            return ;
        }
        int search(int i,int l,int r){
            if(tr[i].l>=l && tr[i].r<=r)
                return tr[i].num;
            if(tr[i].r<l || tr[i].l>r)  return 0;
            push_down(i);
            int s=0;
            if(tr[i*2].r>=l)  s+=search(i*2,l,r);
            if(tr[i*2+1].l<=r)  s+=search(i*2+1,l,r);
            return s;
        }
    }

    public static void main(String[] args) throws IOException {
        SegmentTree segmentTree=new SegmentTree();
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        //String[] split = sc.readLine().split("\\s+");
        //n=Integer.parseInt(split[0]);
        //q=Integer.parseInt(split[1]);
        //Arrays.fill(a,2147483647);
        segmentTree.build(1,1,5);
        /*for(int i=0;i<q;i++){
            String[] s = sc.readLine().split("\\s+");
            int a,b,c;
            a=Integer.parseInt(s[0]);
            b=Integer.parseInt(s[1]);
            c=Integer.parseInt(s[2]);
            if(a==0){
              segmentTree.modify(1,b+1,c);
            }else if(a==1){
                System.out.println(segmentTree.query_min(1,b+1,c+1));
            }
        }*/
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
       segmentTree.modifyRange(1,2,4,10);
       //segmentTree.query_sum(1,2,4);
        segmentTree._reverse(1,2,4);
        segmentTree._reverse(1,2,4);
        System.out.println(segmentTree.query_sum(1,3,5));

    }
}
