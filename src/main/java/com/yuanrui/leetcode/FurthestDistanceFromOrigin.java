package com.yuanrui.leetcode;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/27-10:31
 */
public class FurthestDistanceFromOrigin {

    public static void main(String[] args) {
        System.out.println(furthestDistanceFromOrigin("L_RL__R"));
        System.out.println(furthestDistanceFromOrigin("_R__LL_"));
        System.out.println(furthestDistanceFromOrigin("_______"));
    }


    public static int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int countstar = 0;

        for (int i = 0; i < moves.length(); ++i) {
            if (moves.charAt(i) == 'L') {
                countL++;
            } else if (moves.charAt(i) == 'R') {
                countR++;
            } else {
                countstar++;
            }
        }

        return Math.abs(countL - countR) + countstar;
    }
}

