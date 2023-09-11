package com.yuanrui.leetcode;


/**
 * 1094. 拼车
 */
public class CarPooling {

    /**
     * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
     * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
     * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
     * 示例 1：
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
     * 输出：false
     * 示例 2：
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
     * 输出：true
     */

    public boolean carPooling(int[][] trips, int capacity) {
        // 找到最远的距离
        int far = 0;
        for (int[] trip : trips) {
            far = Math.max(far, trip[2]);
        }
        int[] diff = new int[far + 2];
        diff[0] = capacity;
        for (int[] trip : trips) {
            diff[trip[1] + 1] -= trip[0];
            diff[trip[2] + 1] += trip[0];
        }
        int accum = 0;
        for (int j : diff) {
            accum += j;
            if (accum < 0)
                return false;
        }
        return true;

    }
}
