package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/4-22:45
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
