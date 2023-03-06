package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] flag = new boolean[row][column];//默认是false，没被走过
        int maxArea = 0;
        for(int i = 0; i < row; ++i){
            for(int j = 0; j < column; ++j){
                if(!flag[i][j] && grid[i][j] == 1){
                    int area = 1;
                    Queue<Pixel> node = new ArrayDeque();
                    node.add(new Pixel(i,j,grid[i][j]));
                    flag[i][j] = true;

                    while(!node.isEmpty()){
                        Pixel pix = node.poll();
                        int x = pix.x;
                        int y = pix.y;
                        int val = pix.val;
                        if(y-1 >= 0 && !flag[x][y-1] && grid[x][y-1] == val){
                            flag[x][y-1] = true;
                            area++;
                            node.add(new Pixel(x,y-1,val));
                        }
                        if(y+1 < column && !flag[x][y+1] && grid[x][y+1] == val){
                            flag[x][y+1] = true;
                            area++;
                            node.add(new Pixel(x,y+1,val));
                        }
                        if(x-1 >= 0 && !flag[x-1][y] && grid[x-1][y] == val){
                            flag[x-1][y] = true;
                            area++;
                            node.add(new Pixel(x-1,y,val));
                        }
                        if(x+1 < row && !flag[x+1][y] && grid[x+1][y] == val){
                            flag[x+1][y] = true;
                            area++;
                            node.add(new Pixel(x+1,y,val));
                        }
                    }
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int countArea(int[][] image,boolean[][] flag,int row,int column, int sr, int sc) {
        int area = 1;
        Queue<Pixel> node = new ArrayDeque();

        node.add(new Pixel(sr,sc,image[sr][sc]));
        flag[sr][sc] = true;

        while(!node.isEmpty()){
            Pixel pix = node.poll();
            int x = pix.x;
            int y = pix.y;
            int val = pix.val;
            if(y-1 >= 0 && !flag[x][y-1] && image[x][y-1] == val){
                flag[x][y-1] = true;
                area++;
                node.add(new Pixel(x,y-1,val));
            }
            if(y+1 < column && !flag[x][y+1] && image[x][y+1] == val){
                flag[x][y+1] = true;
                area++;
                node.add(new Pixel(x,y+1,val));
            }
            if(x-1 >= 0 && !flag[x-1][y] && image[x-1][y] == val){
                flag[x-1][y] = true;
                area++;
                node.add(new Pixel(x-1,y,val));
            }
            if(x+1 < row && !flag[x+1][y] && image[x+1][y] == val){
                flag[x+1][y] = true;
                area++;
                node.add(new Pixel(x+1,y,val));
            }
        }

        return area;
    }
}
