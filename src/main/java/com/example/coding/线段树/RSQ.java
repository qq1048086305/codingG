package com.example.coding.线段树;

/**
 * @Author 神様だよ
 * @Date 2021/11/7 21:51
 * @Version 1.0
 * @description:
 */
public class RSQ {
    static int maxn =(int) 1e5 + 7;

    static int n, m, s, t;
    static int ans;
    static int a[]=new int[maxn];
    static class Node
    {
        int l, r;
        int num;
        int lz=0;
        public Node(int l, int r, int num) {
            this.l = l;
            this.r = r;
            this.num = num;
        }
    }
    static class SegmentTree
    {

        Node tr[]=new Node[maxn];
        void build(int p, int l, int r)
        {
            tr[p] = new Node(l, r, 0);
            if(l == r) {
                tr[p].num = a[l];
                return ;
            }
            int mid = l + r >> 1;
            build(2*p, l, mid);
            build(2*p+1, mid + 1, r);
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
        void modify(int p, int l, int r, int k)
        {
            if(tr[p].l >= l && tr[p].r <= r) {
                tr[p].num += k;
                return ;
            }
            int mid = tr[p].l + tr[p].r >> 1;
            if(l <= mid) modify(p << 1, l, r, k);
            if(r > mid) modify(p << 1 | 1, l, r, k);
        }
        //区间查询

        void query(int p, int x)
        {
            ans += tr[p].num;
            if(tr[p].l == tr[p].r) return 	;
            int mid = tr[p].l + tr[p].r >> 1;
            if(x <= mid) query(p << 1, x);
            else query(p << 1 | 1, x);
        }
        void add(int i,int l,int r,int k)
        {
            if(tr[i].r<=r && tr[i].l>=l)//如果当前区间被完全覆盖在目标区间里，讲这个区间的sum+k*(tree[i].r-tree[i].l+1)
            {
                tr[i].num+=k*(tr[i].r-tr[i].l+1);
                tr[i].lz+=k;//记录lazytage
                return ;
            }
            push_down(i);//向下传递
            if(tr[i*2].r>=l)
                add(i*2,l,r,k);
            if(tr[i*2+1].l<=r)
                add(i*2+1,l,r,k);
            tr[i].num=tr[i*2].num+tr[i*2+1].num;
            return ;
        }
        void push_down(int i)
        {
            if(tr[i].lz!=0)
            {
                tr[i*2].lz+=tr[i].lz;//左右儿子分别加上父亲的lz
                tr[i*2+1].lz+=tr[i].lz;
                int mid=(tr[i].l+tr[i].r)/2;
                tr[i*2].num+=tr[i].lz*(mid-tr[i*2].l+1);//左右分别求和加起来
                tr[i*2+1].num+=tr[i].lz*(tr[i*2+1].r-mid);
                tr[i].lz=0;//父亲lz归零
            }
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

    //测试给一段区间加一段值
    public static void main(String[] args) {
            n = 100;
            for (int i = 1; i <= n; ++ i) {
                a[i] = i;
            }
            SegmentTree ST=new SegmentTree();
            ST.build(1, 1, n);
            m = 10;
            while(m -->0 ) {
                int l = 1, r = 100;
                ST.modify(1, l, r, 10000);
                ans = 0;
                ST.query(1, 50);
                //cout << ans << endl;
                ans = 0;
                ST.query(1, 100);
                System.out.println(ans);
            }
    }
}
