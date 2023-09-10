package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 8029. Points That Intersect With Cars
 *
 * @author: yuanrui
 */
public class NumberOfPoints {

    public static void main(String[] args) {
        List<List<Integer>> ill = new ArrayList<>();
        List<Integer> il1 = new ArrayList<>();
        il1.add(1);
        il1.add(3);
        List<Integer> il2 = new ArrayList<>();
        il2.add(5);
        il2.add(8);
//        List<Integer> il3 = new ArrayList<>();
//        il3.add(4);
//        il3.add(7);

        ill.add(il1);
        ill.add(il2);
//        ill.add(il3);
        System.out.println(numberOfPoints(ill));
    }


    public static int numberOfPoints(List<List<Integer>> nums) {
        int ans = 0;
        int[][] input = new int[nums.size()][];
        for (int i = 0; i < nums.size(); i++) {
            input[i] = nums.get(i).stream().mapToInt(integer->integer).toArray();
        }
        input = mergeClosedIntervals(input);

        for (int i = 0; i < input.length; ++i) {
            ans += (input[i][1] - input[i][0] + 1);
        }

        return ans;
    }



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
