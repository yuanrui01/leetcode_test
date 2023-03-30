package com.yuanrui.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/31-1:09
 */
public class SettZeroes {

    public void setZeroes(int[][] matrix) {
        Set<Integer> ilx = new HashSet<>();
        Set<Integer> ily = new HashSet<>();

        int r = matrix.length;
        int c = matrix[0].length;

        for(int i = 0; i < r; ++i) {
            for(int j = 0; j < c; ++j){
                if(matrix[i][j] == 0){
                    ilx.add(i);
                    ily.add(j);
                }
            }
        }

        for(int i = 0; i < r; ++i) {
            if(ilx.contains(i)){
                for(int j = 0; j < c; ++j){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < c; ++j) {
            if(ily.contains(j)){
                for(int i = 0; i < r; ++i){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
