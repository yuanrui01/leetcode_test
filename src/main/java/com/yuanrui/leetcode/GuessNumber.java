package com.yuanrui.leetcode;

/**
 * 374. 猜数字大小
 */
public class GuessNumber {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int middle = left + ((right - left) >>> 1);
            int res = guess(middle);
            if (res == 0)
                return middle;
            else if (res == -1)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    int guess(int num) {
        return Integer.MAX_VALUE;
    }
}
