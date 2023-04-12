package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/12-22:47
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int ans = 0;
        int r = grid.length;
        int c = grid[0].length;
        int[][] access = new int[r][c];

        for(int i = 0; i < r; ++i){
            for (int j = 0; j < c; ++j){
                if(grid[i][j] == '1' && access[i][j] == 0){
                    ans++;
                    access[i][j] = 1;
                    mark(access, grid, r, c, i, j);
                }
            }
        }

        return ans;
    }

    private void mark(int[][] access, char[][] grid, int r, int c, int i, int j){
        if ((i - 1 >= 0) && grid[i - 1][j] == '1' && access[i-1][j] == 0){
            access[i-1][j] = 1;
            mark(access, grid, r, c,i-1,j);
        }
        if((i + 1) < r && grid[i + 1][j] == '1' && access[i+1][j] == 0){
            access[i+1][j] = 1;
            mark(access, grid, r, c,i+1,j);
        }
        if((j - 1 >= 0) && grid[i][j - 1] == '1' && access[i][j - 1] == 0){
            access[i][j - 1] = 1;
            mark(access, grid, r, c, i,j - 1);
        }
        if((j + 1 < c) && grid[i][j + 1] == '1' && access[i][j + 1] == 0){
            access[i][j + 1] = 1;
            mark(access, grid, r, c, i,j + 1);
        }
    }
}
