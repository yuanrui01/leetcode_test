package com.yuanrui.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422};
        int amount = 9864;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[][] cache = new int[15][100001];
        int ans = traceBack(coins, coins.length - 1, amount, cache);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    /**
     * 示例 1：
     * ==================================
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * ==================================
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * ==================================
     * 输入：coins = [1], amount = 0
     * 输出：0
     */
    private static int traceBack(int[] coins, int idx, int amount, int[][] cache) {
        if (idx == -1) {
            int ans = Integer.MAX_VALUE;
            if (amount == 0)
                ans = 0;
            return ans;
        }
        if (amount < coins[idx]) {
            if (cache[idx][amount] == 0)
                cache[idx][amount] = traceBack(coins, idx - 1, amount, cache);
            return cache[idx][amount];
        }
        if (cache[idx][amount] == 0)
            cache[idx][amount] = traceBack(coins, idx - 1, amount, cache);
        int situation1 = cache[idx][amount];
        if (cache[idx + 1][amount - coins[idx]] == 0)
            cache[idx + 1][amount - coins[idx]] = traceBack(coins, idx, amount - coins[idx], cache);
        int situation2 = cache[idx + 1][amount - coins[idx]];

        return Math.min(situation1, situation2 == Integer.MAX_VALUE ? situation2 : situation2 + 1);
    }
}
