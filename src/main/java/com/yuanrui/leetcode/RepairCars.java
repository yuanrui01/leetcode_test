package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 2594. 修车的最少时间
 */
public class RepairCars {

    private static int[] ranks;

    private static long[][] cache;

    public static long repairCars(int[] ranks, int cars) {
        RepairCars.ranks = ranks;
        RepairCars.cache = new long[ranks.length][cars + 1];
        for (long[] longs : cache) {
            Arrays.fill(longs, -1L);
        }

        return dp(ranks.length - 1, cars);
    }

    private static long dp(int idx, int cars) {
        if (idx == 0) {
            if (cars < 0)
                return Long.MIN_VALUE;
            else
                return (long) ranks[idx] * cars * cars;
        }

        long ans = Long.MAX_VALUE;

        // 选的情况，看看究竟处理几个划算
        for (int i = 1; i <= cars; ++i) {
            if (cache[idx-1][cars-i] == -1) {
                cache[idx-1][cars-i] = dp(idx - 1, cars - i);
            }
            ans = Math.min(ans, Math.max(cache[idx-1][cars-i], (long) ranks[idx] *i*i));
        }
        if (cache[idx-1][cars] == -1) {
            cache[idx-1][cars] = dp(idx-1,cars);
        }
        return cache[idx][cars] = Math.min(ans, cache[idx-1][cars]);
    }

    public static void main(String[] args) {
        int[] ranks = {9,7,10,4,4,8,10,2,7,9,8,1,8,3,1,9,1};
        int cars = 6977;

        System.out.println(repairCars(ranks, cars));
    }
}
