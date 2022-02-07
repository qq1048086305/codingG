package com.example.coding.acwing蓝桥杯.DP.三角形DP;

import java.util.Scanner;

/**
 * @Author 神様だよ
 * @Date 2021/12/12 19:22
 * @Version 1.0
 * @description:
 */
public class 地宫取宝 {
    static int n,m,k,mod;
    static long f[][][][]=new long[52][52][14][14];
    static int map[][]=new int[51][51];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        k=sc.nextInt();
        mod=1000000007;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                map[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<51;i++){
            for(int j=0;j<51;j++){
                for(int k=0;k<14;k++){
                    for(int g=0;g<14;g++){
                        f[i][j][k][g]=-1;
                    }
                }
            }
        }
        //搜出来
        //这里不能出现负数保存dp数组时候加一个1来保存
        dfs(1,1,0,-1);
        System.out.println(f[1][1][0][0]);

    }

    private static long dfs(int row, int col, int num, int value) {
        if(f[row][col][num][value+1]!=-1){
            return f[row][col][num][value+1];
        }
        if(row<1||col<1||col>m||row>n){
            return f[row][col][num][value+1]=0;
        }
        //来到终点 满足条件 方案数+1
        if(row==n&&col==m){
           if(num==k||map[row][col]>value&&num+1==k){
               return f[row][col][num][value+1]=1;
           }else{
               return f[row][col][num][value+1]=0;
           }
        }
        if(map[row][col]>value){
            long ans=(dfs(row+1,col,num+1,map[row][col])%mod+
                    dfs(row,col+1,num+1,map[row][col])%mod+
                    dfs(row,col+1,num,value)%mod+
                    dfs(row+1,col,num,value)%mod)%mod;
            f[row][col][num][value+1]=ans;
            return f[row][col][num][value+1];
        }else{
            long ans=(dfs(row+1,col,num,value)%mod+dfs(row,col+1,num,value)%mod)%mod;
            f[row][col][num][value+1]=ans;
            return f[row][col][num][value+1];
        }

    }

}
