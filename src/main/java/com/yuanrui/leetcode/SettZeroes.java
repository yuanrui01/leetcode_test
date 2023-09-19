package com.yuanrui.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 * @author yuanrui
 */
public class SettZeroes {

    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean[] rowFlag = new boolean[r];
        boolean[] columnFlag = new boolean[c];

        for(int i = 0; i < r; ++i)
            for(int j = 0; j < c; ++j)
                if (matrix[i][j] == 0)
                    rowFlag[i] = columnFlag[j] = true;
        for (int i = 0; i < r; i++)
            if (rowFlag[i])
                for (int j = 0; j < c; ++j)
                    matrix[i][j] = 0;
        for (int i = 0; i < c; i++)
            if (columnFlag[i])
                for (int j = 0; j < r; ++j)
                    matrix[j][i] = 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        SettZeroes settZeroes = new SettZeroes();
        settZeroes.setZeroes(matrix);
    }
}
