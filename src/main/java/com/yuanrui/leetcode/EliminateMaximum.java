package com.yuanrui.leetcode;

import java.util.Arrays;

/**
 * @author: yuanrui
 */
public class EliminateMaximum {

    public static void main(String[] args) {
        int[] dist = {1,1,2,3};
        int[] speed = {1,1,1,1};
        System.out.println(eliminateMaximum(dist, speed));

//        double[] seconds = new double[dist.length];
//        for (int i = 0; i < dist.length; i++) {
//            seconds[i] = Math.ceil((double)dist[i]/speed[i]);
//        }
//
//        System.out.println(Arrays.toString(seconds));
    }

    public static int eliminateMaximum(int[] dist, int[] speed) {
        int ans = 0;
        int[] seconds = new int[dist.length];
        for (int i = 0; i < dist.length; i++)
            seconds[i] = (int)Math.ceil((double)dist[i]/speed[i]);
        Arrays.sort(seconds);
        for (int i = 0; i < seconds.length; ++i)
            if (seconds[i] - i >= 0)
                ans++;
            else
                break;;
        return ans;
    }
}
