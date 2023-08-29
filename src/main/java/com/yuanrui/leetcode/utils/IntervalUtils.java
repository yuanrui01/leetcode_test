package com.yuanrui.leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalUtils {

    /**
     * 闭区间合并算法
     * @param intervals
     * @return
     */
    public static int[][] mergeClosedIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][0];
        if (intervals.length == 1)
            return intervals;
        // 对区间按照起始位置进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 如果当前区间的结束位置大于等于下一个区间的起始位置，说明两个区间有重叠
            if ((currentInterval[1] + 1) >= interval[0]) {
                // 更新当前区间的结束位置为两个区间的最大值
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // 没有重叠，将当前区间添加到结果列表中，并更新当前区间为下一个区间
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }
        // 添加最后一个区间
        mergedIntervals.add(currentInterval);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
