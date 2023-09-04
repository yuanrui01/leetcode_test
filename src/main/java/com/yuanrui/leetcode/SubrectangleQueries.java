package com.yuanrui.leetcode;

/**
 * 1476. 子矩形查询
 */
public class SubrectangleQueries {

    private int[][] matrix;
    private int row;
    private int column;

    public SubrectangleQueries(int[][] rectangle) {
        matrix= rectangle;
        row = rectangle.length;
        column = rectangle[0].length;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i < row2; ++i) {
            for (int j = col1; j < col2; ++j) {
                matrix[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return matrix[row][col];
    }

    /**
     * ["SubrectangleQueries",
     * "getValue",
     * "updateSubrectangle",
     * "getValue",
     * "getValue",
     * "updateSubrectangle",
     * "getValue",
     * "getValue"]
     *
     * [
     *   [
     *   [[1,2,1],[4,3,4],[3,2,1],[1,1,1]]
     *   ],
     *
     *   [0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
     * @param args
     */
    public static void main(String[] args) {

    }
}
