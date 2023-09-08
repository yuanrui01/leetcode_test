package com.yuanrui.leetcode;

/**
 * 2651. 计算列车到站时间
 */
public class FindDelayedArrivalTime {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
