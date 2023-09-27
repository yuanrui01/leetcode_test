package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


/**
 * 436. 寻找右区间
 */
public class FindRightInterval {

    /**
     * 暴力走一发，证明我来过
     * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都不同 。
     * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。注意i可能等于 j 。
     * 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
     */
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[][] startIndex = new int[len][2];
        for (int i = 0; i < len; ++i) {
            startIndex[i][0] = intervals[i][0];
            startIndex[i][1] = i;
        }
        Arrays.sort(startIndex, Comparator.comparingInt(v -> v[0]));
        int[] ans = new int[len];
        for(int i = 0; i < len; ++i) {
            int left = 0;
            int right = len - 1;
            int middle;
            int target = -1;
            while (left <= right) {
                middle = (left + right) >> 1;
                if (startIndex[middle][0] >= intervals[i][1]) {
                    right = middle - 1;
                    target = startIndex[middle][1];
                } else {
                    left = middle + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }

    public int[] findRightInterval2(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, Comparator.comparingInt(o -> o[0]));
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    target = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{3,4},{2,3},{1,2}};
        FindRightInterval findRightInterval = new FindRightInterval();
        int[] ans = findRightInterval.findRightInterval(intervals);
        System.out.println(Arrays.toString(ans));
    }
}
