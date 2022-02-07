package com.example.coding.leecode.搜索;

/**
 * @Author 神様だよ
 * @Date 2021/12/1 22:35
 * @Version 1.0
 * @description:
 */
public class leecode39找出值为sum的所有组合 {
    /**
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     */
    /**
     * 注意:枚举的时候的小细节，枚举每个数字选多少个的时候，
     * 本来是枚举多少个，最后dfs下一层完后，就应该全部恢复现场，
     * 删除多少个，再枚举下一种情况。可以直接枚举该数字选多少个，
     * 假设最多能选t个，则每选一个dfs一次，操作了t + 1次之后，
     * 再把这t个相同的数字一次性恢复现场 (y总的小技巧)
     *
     * 时间复杂度
     */
    //https://leetcode.com/problems/combination-sum/submissions/
}
