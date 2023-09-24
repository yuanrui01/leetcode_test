package com.yuanrui.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class MaximumSumOfHeights2 {
    Map<Integer, Long> leftCache;
    Map<Integer, Long> rightCache;

    public static void main(String[] args) {
        MaximumSumOfHeights2 maximumSumOfHeights = new MaximumSumOfHeights2();

        System.out.println(maximumSumOfHeights.maximumSumOfHeights(List.of(6,5,3,9,2,7)));
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        leftCache = new HashMap<>();
        rightCache = new HashMap<>();
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
        long leftCacheVal = 0L;
        if (left >= 0) {
            while (left >= 0) {
                if (leftCache.get(left + 1) != null) {
                    ans += leftCache.get(left + 1);
                    break;
                } else {
                    preMin = Math.min(array[left], preMin);
                    ans += preMin;
                    left--;
                }
            }
            leftCacheVal = ans;
            leftCache.put(i, ans);
        }
        preMin = array[i];
        if (right < array.length) {
            while (right < array.length) {
                if (rightCache.get(left - 1) != null) {
                    ans += leftCache.get(right - 1);
                    break;
                } else {
                    preMin = Math.min(array[right], preMin);
                    ans += preMin;
                    right++;
                }
            }
            rightCache.put(i, ans - leftCacheVal);
        }
        ans += array[i];
        return ans;
    }
}
