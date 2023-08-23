package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
 * 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix2 {


    public static void main(String[] args) {
        int n = 3;
        int[][] solve = solve(n);
        System.out.printf(Arrays.toString(solve));
    }

    public static int[][] solve(int n) {
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = 1;
        } else {
            int orginal_n = n;
            int val = 1;
            int diff = 0;
            int x = 0;
            int y = 0;
            while ( n > 0) {
                if (n == 1) {
                    // TODO:直接赋值
                    result[orginal_n / 2][orginal_n / 2] = orginal_n * orginal_n;
                    --n;
                } else {
                    //右
                    for (int i = 0; i < n; ++i){
                        result[x][y] = val++;
                        y += 1;
                    }
                    y -= 1;
                    x += 1;
                    //下
                    for (int i = 0; i < n - 1; ++i){
                        result[x][y] = val++;
                        x += 1;
                    }
                    x -= 1;
                    y -= 1;
                    //左
                    for (int i = 0; i < n - 1; ++i){
                        result[x][y] = val++;
                        y -= 1;
                    }
                    y += 1;
                    x -= 1;
                    //上
                    for (int i = 0; i < n - 2; ++i) {
                        result[x][y] = val++;
                        x -= 1;
                    }
                    x += 1;
                    y += 1;
                    n-=2;
                    diff++;
                }
            }
        }
        return result;
    }
}
