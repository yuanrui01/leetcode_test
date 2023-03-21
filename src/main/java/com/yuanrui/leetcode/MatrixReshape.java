package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/21-3:01
 */
public class MatrixReshape {

    public static void main(String[] args) {
        matrixReshape(new int[][]{{1,2,3,4}},2,2);
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if(m*n != r*c){
            return mat;
        }else{
            int[][] res = new int[r][c];

            int k = 0;

            for(int i = 0; i < r; ++i){
                for(int j = 0; j < c; ++j){
                    res[i][j] = mat[k/n][k%n];
                    ++k;
                }
            }

            return res;
        }
    }
}
