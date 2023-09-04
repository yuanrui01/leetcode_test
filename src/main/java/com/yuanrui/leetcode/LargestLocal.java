package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * @author: yuanrui
 */
public class LargestLocal {

    public static void main(String[] args) {
        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
//        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(largestLocal(grid)));
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        // 遍历所有3*3子矩阵的中点
        for (int i = 1; i < n - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                ans[i-1][j-1] = maxVal(grid, i, j);
            }
        }
        return ans;
    }

    private static int maxVal(int[][] grid, int m, int n) {
        int ans = Integer.MIN_VALUE;
        for (int i = m - 1; i <= (m + 1); ++i) {
            for (int j = n - 1; j <= (n + 1); ++j) {
                ans = Math.max(ans, grid[i][j]);
            }
        }
        return ans;
    }
}
