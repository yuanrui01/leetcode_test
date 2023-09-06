package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 309. 买卖股票的最佳时机含冷冻期
 * @author: yuanrui
 */
public class MaxProfit2 {

    private int[][] cache;
    private int[] prices;

    public int maxProfit(int[] prices) {
        cache = new int[prices.length][2];
        this.prices = prices;
        for (int[] ints : this.cache) {
            Arrays.fill(ints, -1);
        }

        return dp(prices.length - 1, 0);
    }

    private int dp(int idx, int hold) {
        if (idx < 0)
            return hold == 1 ? Integer.MIN_VALUE : 0;
        if (cache[idx][hold] != -1)
            return cache[idx][hold];
        if (hold == 1)
            return cache[idx][hold] = Math.max(dp(idx - 1, 1), dp(idx - 2, 0) - prices[idx]);
        else
            return cache[idx][hold] = Math.max(dp(idx - 1, 0), dp(idx - 1, 1) + prices[idx]);
    }
}
