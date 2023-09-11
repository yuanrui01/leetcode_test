package com.yuanrui.leetcode;

/**
 * 2406. 将区间分为最少组数
 * @author: yuanrui
 */
public class MinGroups {
    public int minGroups(int[][] intervals) {
        int[] diff = new int[1000002];
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
