package com.example.coding.归并;

/**
 * @Author 神様だよ
 * @Date 2021/11/5 20:42
 * @Version 1.0
 * @description:
 */
public class 分支 {
    static int temp[]=new int[1005];
    public static void mergeSort(int[] arr,int l,int r){
        if(l >= r) return;                      //递归结束条件
        int mid = l + (r - l)/2;                //将数组分成[L,mid] 和 [mid+1,R] 两部分
        mergeSort(arr,l,mid);                   //递归排序左半部分
        mergeSort(arr,mid+1,r);                 //递归排序右半部分
        int i = l;                              //左半部分的指针
        int j = mid + 1;                        //右半部分的指针
        int k = 0;                              //临时存储数组的索引
        while(i <= mid && j <= r){              //循环找到两部分中更小的那个数
            if(arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];          //temp为临时存储数组
        }
        while(i <= mid) temp[k++] = arr[i++];   //把左半部分没存入的数存到临时存储数组中
        while(j <= r) temp[k++] = arr[j++];     //把右半部分没存入的数存到临时存储数组中
        for(i = l,j = 0; i <= r; i++,j++){      //将临时存储数组中排好序的数复制到原数组中
            arr[i] = temp[j];
        }
    }
}
