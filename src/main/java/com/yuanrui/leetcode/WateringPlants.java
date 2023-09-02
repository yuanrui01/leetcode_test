package com.yuanrui.leetcode;

/**
 * 2079. 给植物浇水
 * @author: yuanrui
 */
public class WateringPlants {

    public static void main(String[] args) {
        int[] plants = {1,1,1,4,2,3};
        int capacity = 4;
        System.out.println(wateringPlants(plants, capacity));
    }

    public static int wateringPlants(int[] plants, int capacity) {
        int ans = 0;
        int remainder = capacity;

        for (int i = 0; i < plants.length; ++i) {
            if (remainder >= plants[i]) {
                remainder -= plants[i];
                ans++;
            } else {
                //int needed = plants[i] - remainder;
                int needed = plants[i];
                // 需要多少趟
                int loops = (needed % capacity == 0) ? needed / capacity : needed / capacity + 1;
                ans += (2 * loops * (i+1)) - 1;
                remainder = (needed % capacity == 0) ? 0 : capacity - needed % capacity;
            }
        }
        return ans;
    }
}
