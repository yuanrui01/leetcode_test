package com.yuanrui.leetcode.contest;

import java.util.HashMap;
import java.util.Map;

public class MinOperations3 {

    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (Integer value : map.values()) {
            if (value == 1)
                return -1;
            else if (value == 2)
                ans += 1;
            else if (value%3 == 0)
                ans += value / 3;
            else if (value%3 == 1)
                ans += ((value - 4)/3 + 2);
            else
                ans += (value/3 + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinOperations3 minOperations3 = new MinOperations3();
        int[] nums = {2,3,3,2,2,4,2,3,4};
        System.out.println(minOperations3.minOperations(nums));
    }
}
