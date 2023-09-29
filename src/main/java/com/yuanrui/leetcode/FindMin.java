package com.yuanrui.leetcode;


import java.util.Collections;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 154. 寻找旋转排序数组中的最小值 II
 */
public class FindMin {

    public int findMinRight(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minIdx= nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (nums[middle] < nums[minIdx]) {
                right = middle - 1;
                minIdx = middle;
            } else if (nums[middle] > nums[nums.length - 1]){
                left = middle + 1;
            } else {
                right = right - 1;
            }
        }
        return nums[minIdx];
    }

    public int findMinLeft(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minIdx= nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (nums[middle] < nums[minIdx]) {
                right = middle - 1;
                minIdx = middle;
            } else if (nums[middle] > nums[nums.length - 1]){
                left = middle + 1;
            } else {
                left = left + 1;
            }
        }
        return nums[minIdx];
    }


    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] nums = {2,2,2,0,2,2};
        System.out.println(Math.min(findMin.findMinRight(nums), findMin.findMinLeft(nums)));
    }
}
