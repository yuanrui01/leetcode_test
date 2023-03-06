package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int column = image[0].length;
        boolean[][] flag = new boolean[row][column];
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
                node.add(new Pixel(x,y-1,val));
            }
            if(y+1 < column && !flag[x][y+1] && image[x][y+1] == val){
                flag[x][y+1] = true;
                node.add(new Pixel(x,y+1,val));
            }
            if(x-1 >= 0 && !flag[x-1][y] && image[x-1][y] == val){
                flag[x-1][y] = true;
                node.add(new Pixel(x-1,y,val));
            }
            if(x+1 < row && !flag[x+1][y] && image[x+1][y] == val){
                flag[x+1][y] = true;
                node.add(new Pixel(x+1,y,val));
            }
        }

        for(int i = 0; i < row; ++i){
            for(int j = 0; j < column; ++j){
                if(flag[i][j]){
                    image[i][j] = color;
                }
            }
        }

        return image;
    }
}

class Pixel{
    int x;
    int y;
    int val;

    public Pixel(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
