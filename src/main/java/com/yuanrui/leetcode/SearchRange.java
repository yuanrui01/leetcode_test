package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/22-10:00
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if(start == nums.length || nums[start] != target){
            return new int[]{-1,-1};
        }

        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private int lowerBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            //循环不变量
            //nums[left-1] < target
            //nums[right+1] >= target
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }
}
