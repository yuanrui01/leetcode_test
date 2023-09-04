package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2274. 不含特殊楼层的最大连续楼层数
 * @author: yuanrui
 */
public class MaxConsecutive {

    public static void main(String[] args) {
        System.out.println(maxConsecutive(2,9,new int[]{4,6}));
    }

    public static int maxConsecutive(int bottom, int top, int[] special) {
        int ans = 0;

        int spIdx = 0;
        Arrays.sort(special);

        int i = bottom;
        while (i <= top && spIdx < special.length) {
            ans = Math.max(ans, special[spIdx] - i);
            i = special[spIdx]+1;
            spIdx++;
        }


        return Math.max(ans, top - special[special.length - 1]);
    }
}
