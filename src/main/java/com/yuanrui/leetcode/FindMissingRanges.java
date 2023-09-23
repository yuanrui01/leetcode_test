package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yuanrui
 */
public class FindMissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0)
            return List.of(List.of(lower, upper));
        List<List<Integer>> ans = new ArrayList<>();
        // 1. 数组内找缺失区间
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i+1] - nums[i] > 1)
                ans.add(List.of(nums[i] + 1, nums[i+1] - 1));
        // 2. 两侧找缺失区间
        int smallest = nums[0];
        int biggest = nums[nums.length-1];
        if (lower < smallest)
            ans.add(0, List.of(lower, smallest - 1));
        if (upper > biggest)
            ans.add(List.of(biggest + 1, upper));
        return ans;
    }
}
