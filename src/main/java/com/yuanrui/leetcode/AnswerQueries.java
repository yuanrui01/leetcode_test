package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 2389. 和有限的最长子序列
 * @author: yuanrui
 */
public class AnswerQueries {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i)
            nums[i] += nums[i-1];
        for (int i = 0; i < queries.length; ++i)
            queries[i] = lowerBound(nums, queries[i]+1);

        return queries;
    }


    private static int lowerBound(int[] g, int target) {
        int left = -1, right = g.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = (left + right) >>> 1;
            if (g[mid] < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right; // 或者 left+1
    }
}
