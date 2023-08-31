package com.yuanrui.leetcode;

/**
 * @author: yuanrui
 */
public class NumSpecial {

    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        if (m == 1 && n == 1)
            return mat[0][0];
        int ans = 0;
        int[] flagi = new int[m];
        int[] flagj = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 1 && flagi[i] != 1 && flagj[j] != 1) {
                    if (isSpecial(mat,m,n,i,j)) {
                        ans++;
                        flagi[i] = 1;
                        flagj[j] = 1;
                    }
                }
            }
        }
        return ans;
    }

    private static boolean isSpecial(int[][] mat, int m, int n, int si, int sj) {
        // 向上
        for(int i = sj - 1; i >= 0; --i)
            if (mat[si][i] == 1)
                return false;
        //向下
        for(int i = sj + 1; i < n; ++i)
            if (mat[si][i] == 1)
                return false;
        //向左
        for (int i = si - 1; i >= 0; --i)
            if (mat[i][sj] == 1)
                return false;
        //向右
        for (int i = si + 1; i < m; ++i)
            if (mat[i][sj] == 1)
                return false;
        return true;
    }
}
