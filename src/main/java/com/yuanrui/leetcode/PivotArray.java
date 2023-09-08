package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2161. 根据给定数字划分数组
 */
public class PivotArray {


    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> equals = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot)
                big.add(num);
            else if (num < pivot)
                small.add(num);
            else
                equals.add(num);
        }
        small.addAll(equals);
        small.addAll(big);
        return small.stream().mapToInt(i->i).toArray();
    }
}
