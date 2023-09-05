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

}
