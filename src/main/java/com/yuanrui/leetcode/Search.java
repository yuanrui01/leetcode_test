package com.yuanrui.leetcode;


/**
 * 33. 搜索旋转排序数组
 */
public class Search {

    public int search(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        int leftRes = biSearch(nums, 0, minIdx - 1, target);
        if (leftRes != -1)
            return leftRes;
        return biSearch(nums, minIdx, nums.length - 1, target);
    }

    private int biSearch(int[] nums, int left, int right, int target) {
        int targetIdx = -1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (nums[middle] == target)
                return middle;
            else if (nums[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return targetIdx;
    }

    public int findMinIdx(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) >>> 1;
            if (nums[middle] <= nums[nums.length - 1])
                right = middle - 1;
            else
                left = middle + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        Search search = new Search();

        System.out.println(search.search(nums,0));
    }
}
