package com.yuanrui.leetcode.utils;

import java.util.List;

/**
 * 二分查找工具类
 * @author: yuanrui
 */
public class BitSectUtils {


    // 开区间写法，
    // 对标python bisect_left查找第一个大于等于target的元素的下标，如果不存在则返回数组长度
    private static int lowerBound(List<Integer> g, int target) {
        int left = -1, right = g.size(); // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = (left + right) >>> 1;
            if (g.get(mid) < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right; // 或者 left+1
    }

    private static int lowerBound(int[] g, int target) {
        int left = -1, right = g.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = (left + right) >>> 1;
            if (g[mid] < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right; // 或者 left+1
    }


    /**
     * 第一个小于等于target的元素下标
     * @param g
     * @param target
     * @return
     */
    private static int upperBound(int[] g, int target) {
        int left = -1, right = g.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // nums[left] < target
            // nums[right] >= target
            int mid = (left + right) >>> 1;
            if (g[mid] < target)
                right = mid; // 范围缩小到 (mid, right)
            else
                left = mid; // 范围缩小到 (left, mid)
        }
        return right; // 或者 left+1
    }


    /**
     * 返回第一个小于等于target的元素下标，如果不存在则返回-1
     */
    private static int lessEqualTarget(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (list.get(middle) <= target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return left == 0 ? -1 : left - 1;
    }
}
