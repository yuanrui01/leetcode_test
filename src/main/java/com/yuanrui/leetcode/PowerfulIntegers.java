package com.yuanrui.leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 970. 强整数
 */
public class PowerfulIntegers {

    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2,3,10));
    }


    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        int x_min = 0;
        int y_min = 0;
        int x_max = 0;
        int y_max = 0;
        Set<Integer> ans = new HashSet<>();

        if (x == 1)
            x_min = x_max = 1;
        else
            while (Math.pow(x, x_max + 1) <= bound)
                x_max++;

        if (y == 1)
            y_min = y_max = 1;
        else
            while (Math.pow(y,y_max+1) <= bound)
                y_max++;

        for (int i = x_min; i <= x_max; ++i) {
            for (int j = y_min; j <= y_max; ++j) {
                int d = (int)(Math.pow(x, i) + Math.pow(y,j));
                if (d <= bound)
                    ans.add(d);
            }
        }

        return new ArrayList<>(ans);
    }
}
