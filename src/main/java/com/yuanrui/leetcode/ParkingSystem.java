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

    /**
     * 1）如果可见空间为空，满足以下一个条件即可通过
     *   1.1）不可见空间也为空
     *   1.2) 不可见空间不为空，且不包含本空间
     * 2）如果可见空间不为空，那么仅当可见列表包含本空间才算通过
     * @param args
     */

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(2, 2, 2);
        System.out.println(parkingSystem.addCar(1,));
    }
}
