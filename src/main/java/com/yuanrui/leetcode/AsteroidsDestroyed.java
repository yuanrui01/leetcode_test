package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * 2126. 摧毁小行星
 * @author: yuanrui
 */
public class AsteroidsDestroyed {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long massl = mass;
        for (int i = 0; i < asteroids.length; ++i) {
            if (massl >= asteroids[i])
                massl += asteroids[i];
            else
                return false;
        }

        return true;
    }

    public boolean asteroidsDestroyed2(int mass, int[] asteroids) {
//        int[] sortArr = new int[100001];
//        for (int i = 0; i < asteroids.length; ++i) {
//            sortArr[asteroids[i]]++;
//        }
//        int k = 0;
//        for (int i = 0; i < sortArr.length; i++) {
//            while(sortArr[i] > 0) {
//                asteroids[k++]=i;
//                sortArr[i]--;
//            }
//        }
//
//        long massl = mass;
//        for (int i = 0; i < asteroids.length; ++i) {
//            if (massl >= asteroids[i])
//                massl += asteroids[i];
//            else
//                return false;
//        }
//
        return true;
    }

}
