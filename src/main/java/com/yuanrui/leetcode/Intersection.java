package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 349. 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，
 * 返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int j : nums1) {
            set1.add(j);
        }
        for (int j : nums2) {
            set2.add(j);
        }

        set1.retainAll(set2);
        return set1.stream().mapToInt(i->i).toArray();
    }
}
