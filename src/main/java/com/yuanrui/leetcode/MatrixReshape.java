package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/21-3:01
 */
public class MatrixReshape {

    public static void main(String[] args) {
        matrixReshape(new int[][]{{1},{2},{3},{4}},2,2);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int mat_r = mat.length;
        int mat_c = mat[0].length;

        //条件不满足直接返回
        if(mat_r*mat_c != r*c){
            return mat;
        }

        //新数组
        int[][] newArr = new int[r][c];

        //注意后面算坐标都是通过总数和列数来算的
        for(int i = 1; i <= mat_r; ++i){
            for(int j = 1; j <= mat_c; ++j){
                int t = (i-1)*mat_c + j;
                newArr[(t - 1)/c][(t - 1)%c] = mat[i-1][j-1];
            }
        }

        return newArr;
    }
}
