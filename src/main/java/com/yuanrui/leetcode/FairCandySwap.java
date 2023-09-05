package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 888. 公平的糖果交换
 * @author: yuanrui
 */
public class FairCandySwap {

    public static void main(String[] args) {
        int[] aliceSizes = {1,17,14,1,16};
        int[] bobSizes = {26,11};

        System.out.println(Arrays.toString(fairCandySwap(aliceSizes, bobSizes)));
    }
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] ans = new int[2];
        int aliceSum = 0;
        int bobSum = 0;

        Map<Integer,Integer> bobIdx = new HashMap<>();
        for (int aliceSize : aliceSizes) {
            aliceSum += aliceSize;
        }

        for (int i = 0; i < bobSizes.length; i++) {
            bobSum += bobSizes[i];
            bobIdx.put(bobSizes[i], i);
        }

        int factor = (aliceSum - bobSum)/2;

        for (int i = 0; i < aliceSizes.length; ++i) {
            int anyway = aliceSizes[i] - factor;
            if (anyway < 0)
                continue;
            if (bobIdx.get(anyway) != null) {
                ans[0] = aliceSizes[i];
                ans[1] = bobSizes[bobIdx.get(anyway)];
            }
        }

        return ans;

    }
}
