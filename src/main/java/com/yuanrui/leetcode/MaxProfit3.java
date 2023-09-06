package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 188. 买卖股票的最佳时机 IV
 * @author: yuanrui
 */
public class MaxProfit3 {

    private int[][][] cache;
    private int[] prices;

    public int maxProfit(int k, int[] prices) {
        cache = new int[prices.length][k+1][2];
        this.prices = prices;
        for (int[][] ints : this.cache) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dp(prices.length - 1, k, 0);
    }

    private int dp(int idx, int k, int hold) {
        if (k < 0)
            return Integer.MIN_VALUE;
        if (idx < 0)
            return hold == 1 ? Integer.MIN_VALUE : 0;
        if (cache[idx][k][hold] != -1)
            return cache[idx][k][hold];
        if (hold == 1)
            return cache[idx][k][hold] = Math.max(dp(idx - 1, k, 1), dp(idx - 1, k - 1, 0) - prices[idx]);
        else
            return cache[idx][k][hold] = Math.max(dp(idx - 1, k, 0), dp(idx - 1, k - 1, 1) + prices[idx]);
    }
}
