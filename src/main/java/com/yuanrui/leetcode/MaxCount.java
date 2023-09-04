package com.yuanrui.leetcode;

/**
 * 2554. 从一个范围内选择最多整数 I
 * @author: yuanrui
 */
public class MaxCount {

    public int maxCount(int[] banned, int n, int maxSum) {
        int ans = 0;
        boolean[] isBanned = new boolean[10001];

        for (int i = 0; i < banned.length; ++i) {
            isBanned[banned[i]] = true;
        }

        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            if (!isBanned[i] && (sum + i) <= maxSum) {
                isBanned[i] = true;
                sum += i;
                ans++;
            }
        }
        return ans;
    }
}
