package com.example.coding.leecode.搜索;

/**
 * @Author 神様だよ
 * @Date 2021/12/3 8:04
 * @Version 1.0
 * @description:
 */
public class leecode37SudokuSolver {
    /**
     * 1、预处理出row，col，cell数组，某些元素的位置已经被标识过
     * 2、dfs从(0,0)到(8,8)按顺序递归，假设递归到当前位置是(i,j)
     * 若该位置已经被表示过，则直接跳去下一个位置
     * 若该位置未被表示过，则往该位置尝试填1 到 9 的数字，并在row，col，cell数组中进行标记，用完记得恢复现场
     * 3、当能成功到达最后一个位置，直接返回true，结束递归
     */

    //https://leetcode.com/problems/sudoku-solver/submissions/
}
