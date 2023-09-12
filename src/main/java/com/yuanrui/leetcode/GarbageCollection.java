package com.yuanrui.leetcode;

/**
 * 2391. 收集垃圾的最少总时间
 * @author: yuanrui
 */
public class GarbageCollection {

    public static int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int mSum = 0;
        int pSum = 0;
        int gSum = 0;

        for (int i = 0; i < garbage.length; ++i) {
            if (i > 0) {
                mSum += travel[i-1];
                pSum += travel[i-1];
                gSum += travel[i-1];
            }
            if (garbage[i].indexOf('M') > -1) {
                ans += mSum;
                mSum = 0;
            }
            if (garbage[i].indexOf('P') > -1) {
                ans += pSum;
                pSum = 0;
            }
            if (garbage[i].indexOf('G') > -1) {
                ans += gSum;
                gSum = 0;
            }
            ans += garbage[i].length();
        }
        return ans;
    }

    public static void main(String[] args) {
        GarbageCollection garbageCollection = new GarbageCollection();
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2, 4, 3};
        garbageCollection(garbage, travel);
    }
}
