package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 2592. 最大化数组的伟大值
 * @author: yuanrui
 */
public class MaximizeGreatness {

    public static int maximizeGreatness(int[] nums) {
        int ans = 0;
        int len = nums.length;
        if (len == 1)
            return ans;
        Arrays.sort(nums);
        int j = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[j] > nums[i]) {
                ans++;
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(maximizeGreatness(nums));
    }
}
