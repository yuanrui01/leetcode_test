package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * @description: 1877. 数组中最大数对和的最小值
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/24-21:36
 */
public class MinPairSum {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,4,2,4,6};
        System.out.println(minPairSum(arr));
    }

    public static int minPairSum(int[] nums) {
        if (nums.length == 2)
            return nums[0] + nums[1];

        Arrays.sort(nums);

        int maxNum = 0;
        int length = nums.length;

        for(int i = 0; i < length / 2; ++i) {
            if (nums[i] + nums[length - i - 1] > maxNum)
                maxNum = nums[i] + nums[length - i - 1];
        }

        return maxNum;
    }
}
