package com.example.coding.leecode.前缀和与后缀和;

import java.util.TreeSet;

/**
 * @Author 神様だよ
 * @Date 2022/1/1 19:20
 * @Version 1.0
 * @description:
 */
public class 矩形区域不超过k的最大和 {
    /**
     * 第三重循环的枚举可看作固定了两边和上边（固定为最上边，参考 一维 时固定从0点开始算。一开始想不通四层循环少哪一层，类比一维就知道了），枚举下边，过程中可以用TreeMap二分查找。
     * todo复习时可以是说能不能类似一维去掉前缀和数组。
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int[][] sumMatrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                sumMatrix[i][j] = matrix[i - 1][j - 1] + sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1];

        int ans = Integer.MIN_VALUE;
        for (int col1 = 1; col1 <= m; col1++)
            for (int col2 = col1; col2 <= m; col2++) {
                TreeSet<Integer> tree = new TreeSet<>();
                // sum正好等于k也是符合要求的。
                tree.add(0);
                for (int row2 = 1; row2 <= n; row2++) {
                    int sum = sum(sumMatrix, 1, col1, row2, col2);
                    // sum - t <= k ->  t >= sum - k
                    Integer t = tree.ceiling(sum - k);
                    if (t != null) ans = Math.max(ans, sum - t);
                    tree.add(sum);
                }
            }
        return ans;
    }

    private int sum(int[][] sum, int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
    }
}
