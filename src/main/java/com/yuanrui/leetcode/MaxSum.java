package com.yuanrui.leetcode;

import java.util.*;

/**
 * @author: yuanrui
 */
public class MaxSum {

    public static void main(String[] args) {

        int[] nums = {5,9,9,2,4,5,4};
        int m = 1;
        int k = 3;
        System.out.println(maxSum2(List.of(2,6,7,3,1,7), 3, 4));
        System.out.println(maxSum2(List.of(5,9,9,2,4,5,4), 1, 3));
        System.out.println(maxSum2(List.of(1,2,1,2,1,2,1), 3, 3));
        System.out.println(maxSum2(List.of(1,1,1,2), 2, 4));

        System.out.println(maxSum2(List.of(1), 1, 1));
        System.out.println(maxSum2(List.of(1,1,1,3), 2, 2));
        System.out.println(maxSum2(List.of(1,1,2,2), 1, 3));

        System.out.println(maxSum2(List.of(10,9,7,1,7,6,9,9,9), 3, 3));
    }

    public static long maxSum2(List<Integer> nums, int m, int k) {
        long sum = 0L;
        long tmpSum = 0L;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; ++i) {
            tmpSum += nums.get(i);
            map.merge(nums.get(i), 1, Integer::sum);
        }
        if (map.keySet().size() >= m)
            sum = tmpSum;
        for(int i = 1; i <= nums.size() - k; i+=1) {
            tmpSum -= nums.get(i-1);
            tmpSum += nums.get(i+k-1);
            if (map.get(nums.get(i-1)) == 1)
                map.remove(nums.get(i-1));
            else
                map.merge(nums.get(i-1), -1, Integer::sum);
            map.merge(nums.get(i+k-1), 1, Integer::sum);
            if (map.keySet().size() >= m)
                sum = Math.max(sum, tmpSum);
        }
        return sum;
    }
}
