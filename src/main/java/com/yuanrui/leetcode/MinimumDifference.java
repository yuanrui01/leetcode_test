package com.yuanrui.leetcode;


import java.util.Arrays;

/**
 * 1984. 学生分数的最小差值
 */
public class MinimumDifference {

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{9,4,1,7}, 2));
    }

    public static int minimumDifference(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        if (nums.length == 1)
            return 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - k + 1; ++i) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }
}
