package com.yuanrui.leetcode;


/**
 * 1827. 最少操作使数组递增
 */
public class MinOperations2 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        int ans = 0;
        if (nums.length == 1)
            return ans;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] <= nums[i-1]) {
                int times = nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
                ans += times;
            }
        }
        return ans;
    }
}
