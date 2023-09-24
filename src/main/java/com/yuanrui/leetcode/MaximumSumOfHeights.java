package com.yuanrui.leetcode;

import java.util.List;

/**
 * @author: yuanrui
 */
public class MaximumSumOfHeights {

    public static void main(String[] args) {
        MaximumSumOfHeights maximumSumOfHeights = new MaximumSumOfHeights();

        System.out.println(maximumSumOfHeights.maximumSumOfHeights(List.of(1)));
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int[] array = maxHeights.stream().mapToInt(i -> i).toArray();
        long maxHeightSum = 0L;
        for (int i = 0; i < array.length; ++i) {
            // 返回以i为峰顶的最大高度和
            maxHeightSum = Math.max(maxHeightSum, peakiHeightSum(array, i));
        }
        return maxHeightSum;
    }

    private long peakiHeightSum(int[] array, int i) {
        long ans = 0L;
        int left = i - 1;
        int right = i + 1;
        int preMin = array[i];
        while (left >= 0) {
            preMin = Math.min(array[left], preMin);
            ans += preMin;
            left--;
        }
        preMin = array[i];
        while (right < array.length) {
            preMin = Math.min(array[right], preMin);
            ans += preMin;
            right++;
        }
        ans += array[i];
        return ans;
    }
}
