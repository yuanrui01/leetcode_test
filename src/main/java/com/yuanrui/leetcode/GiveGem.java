package com.yuanrui.leetcode;

/**
 * LCP 50. 宝石补给
 * @author: yuanrui
 */
public class GiveGem {

    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            gem[operation[1]] += gem[operation[0]] / 2;
            gem[operation[0]] = gem[operation[0]] - gem[operation[0]] / 2;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : gem) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return max - min;
    }
}
