package com.yuanrui.leetcode;

/**
 * 2270. 分割数组的方案数
 * @author: yuanrui
 */
public class WaysToSplitArray {


    public int waysToSplitArray(int[] nums) {
        int ans = 0;
        int len = nums.length;

        long[] prefix = new long[len - 1];
        long[] suffix = new long[len - 1];
        long prefixSum = 0;
        long suffixSum = 0;
        for (int i = 0; i < len - 1; ++i) {
            prefixSum += nums[i];
            suffixSum += nums[len - 2 - i];
            prefix[i] = prefixSum;
            suffix[len - 1 - i] = suffixSum;
        }
        for (int i = 0; i < len - 1; ++i) {
            if (prefix[i] >= suffix[i])
                ans++;
        }
        return ans;
    }
}
