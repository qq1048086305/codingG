package com.example.coding;

/**
 * @Author 神様だよ
 * @Date 2021/12/18 18:20
 * @Version 1.0
 * @description:
 */
public class Test08 {
    public static void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean flagA=false,flagB=false;//标记第一行第一列是否能标记
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    if(i==0){
                        flagA=true;
                    }
                    if(j==0){
                        flagB=true;
                    }
                    //标记改行第一个元素
                    matrix[i][0]=0;
                    //标记该列第一个元素
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            //这一行有0
            if(matrix[i][0]==0){
                for(int j=1;j<m;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            //这一列有0
            if(matrix[0][i]==0){
                //这一列置为零
                for(int j=1;j<n;j++){
                    matrix[j][i]=0;
                }
            }
        }
        if(flagB) for(int j = 0;j < m;j ++) matrix[0][j] = 0;
        if(flagA) for(int i = 0;i < n;i ++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{{1,0,3}});
    }
}
