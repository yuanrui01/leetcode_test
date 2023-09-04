package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1471. 数组中的 k 个最强值
 * @author: yuanrui
 */
public class GetStrongest {

    public static void main(String[] args) {
        int[] arr = {6,-3,7,2,11};
        int k = 3;
        System.out.println(Arrays.toString(getStrongest(arr, k)));
    }

    public static int[] getStrongest(int[] arr, int k) {
        int[] ans = new int[k];
        int len = arr.length;

        Arrays.sort(arr);
        int median = arr[(len - 1)/ 2];
        int left = 0;
        int right = len - 1;

        while (left <= right && k >= 1) {
            if (Math.abs(arr[left] - median) < Math.abs(arr[right] - median)) {
                ans[k - 1] = arr[right];
                right--;
            } else if (Math.abs(arr[left] - median) == Math.abs(arr[right] - median) && arr[left] < arr[right]) {
                ans[k - 1] = arr[right];
                right--;
            } else {
                ans[k - 1] = arr[left];
                left++;
            }
            k--;
        }
        return ans;
    }
}
