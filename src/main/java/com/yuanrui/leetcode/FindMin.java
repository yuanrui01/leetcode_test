package com.yuanrui.leetcode;


/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMin {

    public int findMin(int[] nums) {
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
        return nums[left];
    }


    public static void main(String[] args) {
        FindMin findMin = new FindMin();

        int[] nums = {3,4,5,1,1,1,2,3};

        System.out.println(findMin.findMin(nums));
    }
}
