package com.yuanrui.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/22-10:00
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if(start == nums.length || nums[start] != target)
            return new int[]{-1, -1};
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
