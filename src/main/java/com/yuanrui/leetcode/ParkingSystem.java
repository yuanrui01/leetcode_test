package com.yuanrui.leetcode;

/**
 * 1603. 设计停车系统
 * @author: yuanrui
 */
public class ParkingSystem {

    private int bigCnt = 0;
    private int mediumCnt = 0;
    private int smallCnt = 0;

    public ParkingSystem(int big, int medium, int small) {
        bigCnt = big;
        mediumCnt = medium;
        smallCnt = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (bigCnt > 0) {
                    bigCnt--;
                    return true;
                }
                else
                    return false;
            case 2:
                if (mediumCnt > 0) {
                    mediumCnt--;
                    return true;
                }
                else
                    return false;
            case 3:
                if (smallCnt > 0) {
                    smallCnt--;
                    return true;
                }
                else
                    return false;
            default:
                return false;
        }
    }
}
