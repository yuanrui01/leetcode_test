package com.yuanrui.leetcode;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }


    private static final int[] square = new int[] {
        0,1,4,9,16,25,36,49,64,81
    };
    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> happySet = new HashSet<>();
        while (n != 1) {
            if (happySet.contains(n)) {
                return false;
            }
            happySet.add(n);
            String numstr = String.valueOf(n);
            int newn = 0;
            for (int i = 0; i < numstr.length(); ++i) {
                newn += square[Integer.parseInt(numstr.charAt(i) + "")];
            }
            n = newn;
        }
        return true;
    }
}
