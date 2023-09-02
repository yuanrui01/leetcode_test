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
    }

    public static long maxSum2(List<Integer> nums, int m, int k) {
        long sum = 0L;
        if (k == 1) {
            for (Integer num : nums) {
                sum = Math.max(num, sum);
            }
            return sum;
        }

        int[] array = nums.stream().mapToInt(i -> i).toArray();

        //保存上一个相同元素的索引
        if (array.length == k) {
            long tmpSum = 0L;
            Set<Integer> set = new HashSet<>();
            for (int i : array) {
                set.add(i);
                tmpSum += i;
            }
            if (set.size() >= m)
                sum = Math.max(sum, tmpSum);
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            long tmpSum = 0L;
            for (int i = 0; i < k; ++i) {
                tmpSum += array[i];

                map.merge(array[i], 1, Integer::sum);
            }
            if (map.keySet().size() >= m)
                sum = tmpSum;
            for(int i = 1; i <= array.length - k; i+=1) {
                tmpSum -= array[i-1];
                tmpSum += array[i+k-1];
                if (map.containsKey(array[i-1]) && map.get(array[i-1]) == 1)
                    map.remove(array[i-1]);
                map.merge(array[i+k-1], 1, Integer::sum);
                if (map.keySet().size() >= m)
                    sum = Math.max(sum, tmpSum);
            }
        }
        return sum;
    }
}
