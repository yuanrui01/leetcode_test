package com.yuanrui.leetcode;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 2500. 删除每行中的最大值
 */
public class DeleteGreatestValue {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,4},{3,3,1}};

        deleteGreatestValue(grid);
    }

    public static int deleteGreatestValue(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1)
            return grid[0][0];

        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }

        for (int j = 0; j < n; ++j) {
            int maxV = 0;
            for (int i = 0; i < m; ++i) {
                maxV = Math.max(maxV, grid[i][j]);
            }
            ans += maxV;
        }

        return ans;
    }
}
