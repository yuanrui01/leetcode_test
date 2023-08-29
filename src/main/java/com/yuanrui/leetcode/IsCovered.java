package com.yuanrui.leetcode;


import com.yuanrui.leetcode.utils.IntervalUtils;

import java.util.Arrays;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 * 看起来这道题目的数据范围有很多取巧的方法可以用来提速
 */
public class IsCovered {

    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1,2},{3,4},{5,6}};
//        isCovered(ranges, 2, 5);
        isHashCovered(ranges, 2, 5);
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        int[][] mergeRanges = IntervalUtils.mergeClosedIntervals(ranges);
        for (int[] mergeRange : mergeRanges)
            if (left >= mergeRange[0] && right <= mergeRange[1])
                return true;
        return false;
    }

    /**
     * 哈希
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public static boolean isHashCovered(int[][] ranges, int left, int right) {
        int[] rangeFlag = new int[51];
        for (int i = left; i <= right; ++i)
            rangeFlag[i] = 1;
        for (int[] range : ranges)
            for (int j = range[0]; j <= range[1]; ++j)
                rangeFlag[j] = 0;
        for (int i = left; i <= right; ++i)
            if (rangeFlag[i] == 1)
                return false;
        return true;
    }

    /**
     * 哈希2
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    public static boolean isHashCovered2(int[][] ranges, int left, int right) {
        int[] rangeFlag = new int[51];
        for (int[] range : ranges) {
            Arrays.fill(rangeFlag, range[0], range[1] + 1, 1);
        }
        for (int i = left; i <=right; ++i)
            if (rangeFlag[i] != 1)
                return false;
        return true;
    }
}
