package com.yuanrui.leetcode;

/**
 * 2406. 将区间分为最少组数
 * @author: yuanrui
 */
public class MinGroups {
    public int minGroups(int[][] intervals) {
        int maxIdx = -1;
        for (int[] interval : intervals)
            maxIdx = Math.max(maxIdx, interval[1]);
        int[] diff = new int[maxIdx + 2];
        for (int[] interval : intervals) {
            diff[interval[0]] += 1;
            diff[interval[1] + 1] -= 1;
        }
        int sum = 0;
        int ans = 0;
        for (int i : diff) {
            sum += i;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
