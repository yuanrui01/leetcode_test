package com.yuanrui.leetcode;


import java.util.Arrays;

/**
 * 1351. 统计有序矩阵中的负数
 */
public class CountNegatives {

    public static void main(String[] args) {
        int[][] grid = {{5, 1, 1}, {-5, -5, -5}};
        CountNegatives countNegatives = new CountNegatives();
        System.out.println(countNegatives.countNegatives(grid));
    }

    public int countNegatives(int[][] grid) {
        int ans = 0;
        // 每一行去找0的下标
        for (int[] array : grid)
            ans += array.length - firstBeforeZero(array) - 1;
        return ans;
    }

    private int firstBeforeZero(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] >= 0)
                left = left + 1;
            else
                right = right - 1;
        }
        return right;
    }
}
