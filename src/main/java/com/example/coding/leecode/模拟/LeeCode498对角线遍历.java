package com.example.coding.leecode.模拟;

/**
 * @Author 神様だよ
 * @Date 2022/1/21 12:04
 * @Version 1.0
 * @description:
 */
public class LeeCode498对角线遍历 {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] ans = new int[n * m];
        int k = 0;
        //对角线条数是n+m-1条 然后对称取值
        for (int i = 0; i < n + m - 1; i ++) { // 对角线的数量可以由最外围的点的数量确定
            // 确定左下和右上的x取值
            int left_down = Math.min(i, n - 1);
            int right_up = Math.max(0, i - m + 1);

            if (i % 2 == 0) {
                // 偶数, 从左下到右上
                for (int j = left_down; j >= right_up; j --) {
                    ans[k ++] = mat[j][i - j];
                }
            } else {
                // 奇数, 从右上到左下
                for (int j = right_up; j <= left_down; j ++) {
                    ans[k ++] = mat[j][i - j];
                }
            }
        }

        return ans;
    }
}
