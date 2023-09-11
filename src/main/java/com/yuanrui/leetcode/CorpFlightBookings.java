package com.yuanrui.leetcode;


/**
 * 1109. 航班预订统计
 */
public class CorpFlightBookings {

    /**
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     * 解释：
     * 航班编号        1   2   3   4   5
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       20  20
     * 预订记录 3 ：       25  25  25  25
     * 总座位数：      10  55  45  25  25
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 2];
        for (int[] booking : bookings) {
            diff[booking[0]] += booking[2];
            diff[booking[1] + 1] -= booking[2];
        }

        int[] ans = new int[n];

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += diff[i+1];
            ans[i] = sum;
        }
        return ans;
    }
}
