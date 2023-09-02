package com.yuanrui.leetcode;

/**
 * 494. 目标和
 * @author: yuanrui
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{0,1}, 1));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int[] ans = {0};
        targetSumways(ans, nums, nums.length - 1, target);
        return ans[0];
    }

    // 回溯写法
    private static void targetSumways(int[] ans, int[] nums, int idx, int target) {
        if (idx == -1) {
            if (target == 0)
                ans[0]++;
            return;
        }
        targetSumways(ans, nums, idx - 1, target - nums[idx]);
        targetSumways(ans, nums, idx - 1, target + nums[idx]);
    }
}
