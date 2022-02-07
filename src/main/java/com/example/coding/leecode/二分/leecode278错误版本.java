package com.example.coding.leecode.二分;

/**
 * @Author 神様だよ
 * @Date 2021/12/22 14:11
 * @Version 1.0
 * @description:
 */
public class leecode278错误版本 {
    public int firstBadVersion(int n) {
        long l = 1,r = n;
        while(l < r)
        {
            long mid = l + r >> 1;
            if(isBadVersion((int)mid)) r = mid;
            else l = mid + 1;
        }
        return (int)l;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}
