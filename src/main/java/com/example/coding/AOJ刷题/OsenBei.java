package com.example.coding.AOJ刷题;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/11/30 14:43
 * @Version 1.0
 * @description:
 */
public class OsenBei {
    static int map[][]=new int[15][10005];
    static int r,c;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true){
            r=sc.nextInt();
            c=sc.nextInt();
            if(r==0&&c==0){
                return;
            }
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    map[i][j]=sc.nextInt();
                }
            }
            int ans=dfs(1);
            System.out.println(ans);
        }

    }

    private static int dfs(int dep) {
        if(dep>r){
            int ans=Integer.MIN_VALUE/2;
            ans=Math.max(ans,cal());
            return ans;
        }
        int res=Integer.MIN_VALUE/2;
        rev(dep);
        res=Math.max(res,dfs(dep+1));
        rev(dep);//换回来相当于当前行没反转
        res=Math.max(res,dfs(dep+1));
        return res;
    }

    private static int cal() {
        int total=0;
        //统计每一列可以得到的最大贡献
        for(int j=1;j<=c;j++ ){
            int sum=0;
            for(int i=1;i<=r;i++){
                sum+=map[i][j];
            }
            //比较该列反转前和反转后哪一个贡献最大 就要哪一个
            total+=Math.max(sum,r-sum);
        }
        return total;
    }

    private static void rev(int cur) {
        //把当前行反转（1->0 0->1）
        for(int j=1;j<=c;j++){
            map[cur][j]^=1;
        }
    }
}
