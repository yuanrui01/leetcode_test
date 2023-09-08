package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        int shiftTimes = k % size;
        List<List<Integer>> ill = new ArrayList<>();

        if (shiftTimes != 0) {
            int[][] replica = new int[m][n];
            for (int i = 0; i < m; i++)
                replica[i] = Arrays.copyOf(grid[i], n);
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    // 加上shiftTimes，避免循环多次，一步到位
                    int pi = ((j + shiftTimes) / n + i) % m;
                    int pj = (j + shiftTimes) % n;
                    grid[pi][pj] = replica[i][j];
                }
            }
        }
        for (int[] ints : grid) {
            List<Integer> il = new ArrayList<>();
            for (int anInt : ints)
                il.add(anInt);
            ill.add(il);
        }
        return ill;
    }
}
