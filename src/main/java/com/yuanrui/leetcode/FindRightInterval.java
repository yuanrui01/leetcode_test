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
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < len; ++i)
            idxMap.put(intervals[i].hashCode(), i);
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        Map<Integer, Integer> ansMap = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            int iHashCode = intervals[i].hashCode();
            // 对于已经排序的区间，逐个找出其右区间
            int[] leftInterval = intervals[i];
            int leftBegin = leftInterval[0];
            int leftEnd = leftInterval[1];
            if (leftBegin == leftEnd) {
                ansMap.put(iHashCode, iHashCode);
                continue;
            }
            int j = i + 1;
            while (j < len) {
                int rightBegin = intervals[j][0];
                if (leftEnd <= rightBegin) {
                    ansMap.put(iHashCode, intervals[j].hashCode());
                    break;
                }
                ++j;
            }
            if (j == len)
                ansMap.put(iHashCode, -1);
        }
        int[] ans = new int[len];
        for (int[] interval : intervals) {
            int hashcode = interval.hashCode();
            ans[idxMap.get(hashcode)] = ansMap.get(hashcode) == -1 ? -1 : idxMap.get(ansMap.get(hashcode));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 1}, {3, 4}};
        FindRightInterval findRightInterval = new FindRightInterval();
        int[] ans = findRightInterval.findRightInterval(intervals);
        System.out.println(Arrays.toString(ans));
    }
}
