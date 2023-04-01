package com.yuanrui.leetcode;

public class SearchMatrix {

    public static void main(String[] args) {
        //int[][] matrix = new int[3][4]{{1,3,5,7},{1,3,5,7},{1,3,5,7},{1,3,5,7}};
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int len = row*column;

        int begin = 0;
        int end = len - 1;
        while(begin <= end){
            int mid = (begin + end) / 2;
            //如果找到target，返回true
            if(matrix[mid / column][mid % column] > target){
                end = mid - 1;
            }else if(matrix[mid / column][mid % column] < target){
                begin = mid + 1;
            }else{
                return true;
            }
        }

        return false;
    }
}
