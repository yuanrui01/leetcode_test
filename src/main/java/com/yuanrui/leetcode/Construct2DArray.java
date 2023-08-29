package com.yuanrui.leetcode;

import java.util.Arrays;


/**
 * 2022. 将一维数组转变成二维数组
 */
public class Construct2DArray {

    public static void main(String[] args) {
        int[] original = new int[]{1,2,3,4};
        int m = 2, n = 2;
        System.out.println(Arrays.toString(construct2DArray(original, m, n)));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length)
            return new int[0][0];
        int[][] res = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                res[i][j] = original[k++];
        return res;
    }
}
