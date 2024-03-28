package com.yuanrui.leetcode;

public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 2;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (arr[middle] < arr[middle + 1])
                left = middle + 1;
            else if (arr[middle] < arr[middle - 1])
                right = middle - 1;
            else
                return middle;
        }
        return left;
    }
}
