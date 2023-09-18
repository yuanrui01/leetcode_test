package com.yuanrui;


import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class SpiralOrder {

    private int[][] matrix;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        olala(ans, 0, 0, m, n);
        return ans;
    }

    // 只需要遍历外层即可！！！！
    private void olala(List<Integer> ans, int mDiff, int nDiff, int m, int n) {
        for (int j = 0; j < n; ++j)
            ans.add(matrix[mDiff][nDiff + j]);
        for (int j = 1; j < m; ++j)
            ans.add(matrix[mDiff + j][nDiff + n-1]);
        for (int j = n - 2; m > 1 && j >= 0; --j)
            ans.add(matrix[mDiff + m-1][nDiff + j]);
        for (int j = m - 2; n > 1 && j > 0; --j)
            ans.add(matrix[mDiff + j][nDiff]);
        if (m - 2 > 0 && n - 2 > 0)
            olala(ans, ++mDiff, ++nDiff, m - 2, n-2);
    }


    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        spiralOrder.spiralOrder(matrix);
    }
}
