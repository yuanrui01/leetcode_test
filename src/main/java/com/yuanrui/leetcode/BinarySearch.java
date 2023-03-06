package com.yuanrui.leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        searchInsert(nums,target);


        System.out.println(10*10*10*10*10*10*10*10);
    }


    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int mid = -1;
        while(start <= end){
            mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return nums[mid] < target ? mid + 1: mid;
    }
}
