package com.yuanrui.leetcode;

/**
 * 1603. 设计停车系统
 * @author: yuanrui
 */
public class ParkingSystem {
    private final int[] counts;

    public ParkingSystem(int big, int medium, int small) {
        counts = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return counts[carType - 1]-- > 0;
    }

}
