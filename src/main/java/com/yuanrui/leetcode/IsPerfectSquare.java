package com.yuanrui.leetcode;


/**
 * 367. 有效的完全平方数
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int middle = left + ((right - left) >>> 1);
            long midSquqre = (long)middle * middle;
            if (midSquqre == num) {
                return true;
            } else if (midSquqre > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();
        System.out.println(isPerfectSquare.isPerfectSquare(2147483647));
        long l1 = Integer.MAX_VALUE;
        long l2 = Integer.MAX_VALUE;
        System.out.println(l1 * l2);
    }
}
