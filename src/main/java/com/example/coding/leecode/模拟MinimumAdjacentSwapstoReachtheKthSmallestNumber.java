package com.example.coding.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 神様だよ
 * @Date 2021/11/25 10:47
 * @Version 1.0
 * @description:
 */

public class 模拟MinimumAdjacentSwapstoReachtheKthSmallestNumber {
    static class Solution {
        //字符串转数组
        public int getMinSwaps(String num, int k) {
            int[] original = generateDigitArray(num);
            //copy一个用来操作的数组
            int[] copied = Arrays.copyOf(original, original.length);
            //操作k次找到第k小的数
            while (k > 0) {
                nextPermutation(copied);
                k--;
            }
            //比对出操作次数
            return findMinSwaps(original, copied);
        }

        private int findMinSwaps(int[] number, int[] kthSmallestNumber){
            int swapCount = 0;
            int n = number.length;

            for(int i = 0; i < n; i++){
                if(number[i] == kthSmallestNumber[i]) continue;

                int j = i + 1;
                while(j < n && number[i] != kthSmallestNumber[j]){
                    j++;
                }

                while(j > i){
                    swap(kthSmallestNumber, j - 1, j);
                    swapCount++;
                    j--;
                }

            }

            return swapCount;
        }

        private int[] generateDigitArray(String strnum) {
            List<Integer> result = new ArrayList();

            for (int i = 0; i < strnum.length(); i++) {
                result.add(strnum.charAt(i) - '0');
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        //模拟操作
        private void nextPermutation(int[] nums) {
            int length = nums.length;
            //每次从后往前找出第一个正序的数 下标为i
            int i = length - 2;
            while (i >= 0 && nums[i] >= nums[i+1]) i--;
            //从结尾开始找到第一个符合要求的j与i进行交换
            int j = length - 1;
            if (i >= 0) {//可能都是相同的数导致i=-1
                while (j >= 0 && nums[i] >= nums[j]) j--;
                swap(nums, i, j);
            }
            //从i+1到最后让数组逆序
            reverse(nums, i+1, length - 1);
        }

        private void swap(int[] nums, int start, int end) {
            if (start > end) return;

            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
        }

        private void reverse(int[] nums, int start, int end) {
            while (start <= end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }
}
