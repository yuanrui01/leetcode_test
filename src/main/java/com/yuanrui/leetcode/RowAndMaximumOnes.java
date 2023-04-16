package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/16-10:31
 */
public class RowAndMaximumOnes {

    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,1}};
        System.out.println(Arrays.toString(rowAndMaximumOnes(mat)));
    }

    //[[0,0,0],[0,1,1]]
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        int m = mat.length;
        int n = mat[0].length;
        int max_row = -1;

        for(int i = m-1;i >= 0; --i){
            int cnt = 0;
            for(int j = 0; j < n; ++j){
                if(mat[i][j] == 1){
                    cnt++;
                }
            }
            if(cnt >= max_row){
                max_row = cnt;
                ans[0] = i;
                ans[1] = max_row;
            }
        }

        return ans;
    }
}
