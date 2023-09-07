package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2593. 标记所有元素后数组的分数
 * @author: yuanrui
 */
public class FindScore {

    public static long findScore(int[] nums) {
        long score = 0L;
        int len = nums.length;
        Map<Integer, List<Integer>> mapIl = new TreeMap<>();
        boolean[] mark = new boolean[len];

        for (int i = 0 ; i < len; ++i) {
            if (mapIl.get(nums[i]) == null) {
                List<Integer> il = new ArrayList<>();
                il.add(i);
                mapIl.put(nums[i], il);
            } else {
                mapIl.get(nums[i]).add(i);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : mapIl.entrySet()) {
            List<Integer> il = entry.getValue();
            if (il != null && !il.isEmpty()) {
                for (Integer integer : il) {
                    if (!mark[integer]) {
                        score += nums[integer];
                        mark[integer] = true;
                        if (integer - 1 >= 0)
                            mark[integer - 1] = true;
                        if (integer + 1 < len)
                            mark[integer + 1] = true;
                    }
                }
            }
        }

        return score;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5,2};

        System.out.println(findScore(nums));
    }
}
