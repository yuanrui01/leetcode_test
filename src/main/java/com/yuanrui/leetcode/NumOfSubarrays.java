package com.yuanrui.leetcode;


/**
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 */
public class NumOfSubarrays {

    public static void main(String[] args) {
        int[] arr = {11,13,17,23,29,31,7,5,2,3};
        int k = 3;
        int threshold = 5;
        System.out.println(numOfSubarrays(arr, k, threshold));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int slideVal = 0;
        for (int i = 0; i < k; ++i) {
            slideVal += arr[i];
        }
        if (slideVal/k >= threshold)
            ans++;
        for (int i = 0; i < arr.length - k; ++i) {
            slideVal = slideVal + arr[i + k] - arr[i];
            if (slideVal/k >= threshold)
                ans++;
        }
        return ans;
    }
}
