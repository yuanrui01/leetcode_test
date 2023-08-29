package com.yuanrui.leetcode;


import com.yuanrui.leetcode.utils.IntervalUtils;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 */
public class IsCovered {

    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1,2},{3,4},{5,6}};
        isCovered(ranges, 2, 5);
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[][] mergeRanges = IntervalUtils.mergeClosedIntervals(ranges);
        for (int[] mergeRange : mergeRanges)
            if (left >= mergeRange[0] && right <= mergeRange[1])
                return true;
        return false;
    }
}
