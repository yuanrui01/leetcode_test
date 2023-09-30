package com.yuanrui.leetcode.contest;

import java.util.List;

public class MinOperations {

    public int minOperations(List<Integer> nums, int k) {
        boolean[] targtek = new boolean[51];
        int count = 0;
        int ans = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            count++;
            if (!targtek[nums.get(i)] && nums.get(i) <= k)
                ans++;
            if (ans == k)
                break;
            targtek[nums.get(i)] = true;
        }

        return count;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();

        System.out.println(minOperations.minOperations(List.of(2,1),2));
    }
}
