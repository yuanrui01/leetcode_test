package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.Collections;

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

    public static long repairCars2(int[] ranks, int cars) {
        long ans = 0L;

        int min = Integer.MAX_VALUE;
        for (int rank : ranks) {
            min = Math.min(min, rank);
        }


        long left = 0, right = (long) min * cars * cars;
        while (left + 1 < right) { // 区间不为空
            long mid = (left + right) >>> 1;
            if (check(ranks, mid, cars))
                right = mid; // 范围缩小到 (mid, right)
            else
                left = mid; // 范围缩小到 (left, mid)
        }
        return right; // 或者 left+1
    }

    private static boolean check(int[] ranks, long t, int cars) {
        long sum = 0L;
        for (int rank : ranks) {
            sum += Math.floor(Math.sqrt(t/rank));
        }
        return sum >= cars;

    }

    public static void main(String[] args) {
        int[] ranks = {4,2,3,1};
        int cars = 10;

        System.out.println(repairCars2(ranks, cars));
    }
}
