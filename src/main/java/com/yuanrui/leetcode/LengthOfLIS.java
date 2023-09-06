package com.yuanrui.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * @author: yuanrui
 */
public class LengthOfLIS {

    private static int[][] cache;

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        cache = new int[len][20002];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }

        return dfs(nums, len - 1, 10001);
    }

    private static int dfs(int[] nums, int idx, int top) {
        if (idx == 0)
            return nums[0] < top ? 1 : 0;
        if (cache[idx][top + 10000] != -1)
            return cache[idx][top + 10000];

        if (nums[idx] < top)
            return cache[idx][top + 10000] = Math.max(dfs(nums, idx - 1, top), dfs(nums, idx - 1, nums[idx - 1]) + 1);
        else
            return cache[idx][top + 10000] = dfs(nums, idx - 1, top);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
    }
}
