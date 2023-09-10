package com.yuanrui.leetcode;

/**
 * @author: yuanrui
 */
public class IsReachableAtTime {

    public static void main(String[] args) {
        System.out.println(isReachableAtTime(1,1,1,1,3));
    }


    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // 先求最大距离，再求最小距离，只要t在其范围内即视为可到达
        long maxDistance = Math.abs((long)fx - (long)sx) + Math.abs((long)fy - (long)sy);
        long small = Math.min(Math.abs((long)fx - (long)sx), Math.abs((long)fy - (long)sy));
        long big = Math.max(Math.abs((long)fx - (long)sx), Math.abs((long)fy - (long)sy));

        long minDistance = small + (big - small);

        return  t >= minDistance || !((minDistance == 0) && (t == 1));
    }

}
