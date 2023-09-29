package com.yuanrui.leetcode;

/**
 * 1539. 第 k 个缺失的正整数
 */
public class FindKthPositive {

    public int findKthPositive(int[] arr, int k) {
        int ans = 0;
        boolean[] bools = new boolean[1001];
        for (int j : arr) bools[j] = true;
        for(int i = 1; i < bools.length; ++i) {
            if (!bools[i]) {
                k--;
                ans = i;
            }
            if (k == 0)
                return ans;
        }
        return 1000 + k;
    }
}
