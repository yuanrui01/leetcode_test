package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 605. 种花问题
 * @author: yuanrui
 */
public class CanPlaceFlowers {

    // 沙比题
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < flowerbed.length; ++i)
            if (flowerbed[i] == 1)
                list.add(i);
        if (list.isEmpty())
            return ((flowerbed.length + 1) >>> 1) >= n;
        int capacity = 0;
        // 检查查肚子
        for (int i = 0; i < list.size() - 1; ++i) {
            int diff = list.get(i+1) - list.get(i) - 1;
            if (diff - 2 > 0)
                capacity += (diff - 2 + 1);
        }
        // 检查头部
        int headDiff = list.get(0);
        if (headDiff - 1 > 0)
            capacity += headDiff;
        // 检查尾部
        int tailDiff = flowerbed.length - 1 - list.get(list.size() - 1);
        if (tailDiff - 1 > 0)
            capacity += tailDiff;
        return (capacity >>> 1) >= n;
    }

    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        int[] flower = {1,0,0,0,1,0,0};
        int n = 2;
        System.out.println(canPlaceFlowers.canPlaceFlowers(flower, n));

    }
}
