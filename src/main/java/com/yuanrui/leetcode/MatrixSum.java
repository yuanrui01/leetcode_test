package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 2679. 矩阵中的和
 * @author: yuanrui
 */
public class MatrixSum {

    public int matrixSum(int[][] nums) {
        int ans = 0;
        for (int[] num : nums) Arrays.sort(num);
        for (int i = nums[0].length - 1; i >= 0; --i) {
            int maxVal = 0;
            for (int[] num : nums) {
                maxVal = Math.max(maxVal, num[i]);
            }
            ans+=maxVal;
        }
        return ans;
    }
}
