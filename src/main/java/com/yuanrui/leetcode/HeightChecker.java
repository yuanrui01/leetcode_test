package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 1051. 高度检查器
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        if (heights.length == 1)
            return 0;
        int res = 0;
        int[] temp = new int[heights.length];
        System.arraycopy(heights, 0, temp, 0, heights.length);
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; ++i)
            if (temp[i] != heights[i])
                ++res;
        return res;
    }
}
