package com.yuanrui.leetcode;

public class SlowestKey {

    public static void main(String[] args) {
        int[] releaseTimes = new int[]{1,2};
        String keysPressed = "ba";

        System.out.println(slowestKey(releaseTimes, keysPressed));
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        if (releaseTimes.length == 1)
            return keysPressed.charAt(0);

        int slowest = releaseTimes[0];
        char maxchar = keysPressed.charAt(0);

        for (int i = 1; i < keysPressed.length(); ++i) {
            int diff = releaseTimes[i] - releaseTimes[i - 1];
            if (diff > slowest) {
                slowest = releaseTimes[i] - releaseTimes[i - 1];
                maxchar = keysPressed.charAt(i);
            } else if (diff == slowest && keysPressed.charAt(i) > maxchar) {
                maxchar = keysPressed.charAt(i);
            }
        }

        return maxchar;
    }
}
