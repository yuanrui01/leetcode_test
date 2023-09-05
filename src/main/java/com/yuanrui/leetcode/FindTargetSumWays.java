package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 494. 目标和
 * @author: yuanrui
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
//        System.out.println(findTargetSumWays(new int[]{1,999}, 998));

        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    public static int findTargetSumWays2(int[] nums, int target) {
        return backtrack(nums, nums.length - 1, target);
    }


    private static int backtrack(int[] nums, int idx, int target) {
        if (idx == -1) {
            if (target == 0)
                return 1;
            return 0;
        }
        return backtrack(nums, idx - 1, target - nums[idx]) + backtrack(nums, idx - 1, target + nums[idx]);
    }


    public static int findTargetSumWays(int[] nums, int target) {
        for (int num : nums) {
            target += num;
        }
        if (target < 0 || target % 2 != 0)
            return 0;

        int[][] cache = new int[21][1001];
        return dp(nums, nums.length - 1, target/2, cache);
    }


    private static int dp(int[] nums, int idx, int target, int[][] cache) {
        if (idx == 0) {
            int ans = 0;
            if (target == nums[0])
                ans++;
            if (target == 0)
                ans++;
            return ans;
        }
        if (target < nums[idx]) {
            if (cache[idx - 1][target] == 0)
                cache[idx - 1][target] = dp(nums, idx - 1, target, cache);
            return cache[idx - 1][target];
        }
        if (cache[idx - 1][target - nums[idx]] == 0) {
            cache[idx - 1][target - nums[idx]] = dp(nums, idx - 1, target - nums[idx], cache);
        }
        if (cache[idx - 1][target] == 0) {
            cache[idx - 1][target] = dp(nums, idx - 1, target, cache);
        }

        return cache[idx - 1][target - nums[idx]] + cache[idx - 1][target];
    }
}
