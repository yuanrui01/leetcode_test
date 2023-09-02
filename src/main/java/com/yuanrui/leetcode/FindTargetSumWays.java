package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 494. 目标和
 * @author: yuanrui
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
//        System.out.println(findTargetSumWays(new int[]{1,999}, 998));

        System.out.println(findTargetSumWays3(new int[]{1,1,1}, -3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int[][] lazy = new int[nums.length][3003];
        return dp(nums, lazy, nums.length - 1, target);
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

    private static int dp(int[] nums, int[][] lazy,  int idx, int target) {
        if (idx == -1) {
            if (target == 0)
                return 1;
            return 0;
        }
        int res1;
        int res2;

        if (lazy[idx][nums[idx] - target + 1000] != 0)
            res1 = lazy[idx-1][nums[idx] - target + 1000];
        else
            res1 = dp(nums, lazy, idx - 1, target - nums[idx]);

        if (lazy[idx][target + nums[idx] + 1000] != 0)
            res2 = lazy[idx-1][target + nums[idx] + 1000];
        else
            res2 = dp(nums, lazy, idx - 1, target + nums[idx]);

        return res1 + res2;
    }



    private static int[] globalNums;
    private static int[][] cache;

    public static int findTargetSumWays3(int[] nums, int target) {
        for (int x : nums) target += x;
        if (target < 0 || target % 2 == 1) return 0;
        target /= 2;

        globalNums = nums;
        int n = nums.length;
        cache = new int[n][target + 1];
        for (int i = 0; i < n; i++)
            Arrays.fill(cache[i], -1); // -1 表示没用访问过
        return dfs(n - 1, target);
    }

    private static int dfs(int i, int c) {
        if (i < 0) return c == 0 ? 1 : 0;
        if (cache[i][c] != -1) return cache[i][c];
        if (c < globalNums[i]) return cache[i][c] = dfs(i - 1, c);
        return cache[i][c] = dfs(i - 1, c) + dfs(i - 1, c - globalNums[i]);
    }
}
