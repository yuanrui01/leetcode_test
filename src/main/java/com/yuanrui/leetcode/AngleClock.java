package com.yuanrui.leetcode;

/**
 * 1344. 时钟指针的夹角
 * @author: yuanrui
 */
public class AngleClock {

    public static void main(String[] args) {
        System.out.println(angleClock(12,30));
    }

    public static double angleClock(int hour, int minutes) {
        double hourAngle = (hour%12) * 30.0 + 30.0*minutes/60;
        double minuteAngle = minutes*6;

        double includeAngle = Math.abs(minuteAngle - hourAngle);

        return Math.min(includeAngle, 360-includeAngle);
    }

}
