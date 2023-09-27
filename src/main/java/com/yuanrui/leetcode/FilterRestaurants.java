package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1333. 餐厅过滤器
 * @author: yuanrui
 */
public class FilterRestaurants {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        // 先过滤数组再排序
        List<int[]> afterFilter = new ArrayList<>();
        for (int[] restaurant : restaurants)
            if (!((veganFriendly == 1 && restaurant[2] != 1) || (restaurant[3] > maxPrice) || (restaurant[4] > maxDistance)))
                afterFilter.add(restaurant);
        afterFilter.sort((entry1, entry2) -> {
            int id1 = entry1[0];
            int rating1 = entry1[1];
            int id2 = entry2[0];
            int rating2 = entry2[1];
            if (rating1 == rating2)
                return id2 - id1;
            else
                return rating2 - rating1;
        });
//        afterFilter.sort(Comparator.comparingInt((int[] entry) -> entry[1])
//                .reversed()
//                .thenComparingInt(entry -> entry[0]).reversed());
        return afterFilter.stream().map(entry -> entry[0]).toList();
    }
}
