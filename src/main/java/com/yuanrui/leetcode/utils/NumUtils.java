package com.yuanrui.leetcode.utils;

/**
 * 数论工具类
 */
public class NumUtils {

    /**
     * 质数判定，试除法（后续再优化）
     * @param number
     * @return
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 5; i <= sqrt; i += 1) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
