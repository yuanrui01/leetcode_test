package com.yuanrui.leetcode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: yuanrui
 */
public class MinLengthAfterRemovals {

    public static void main(String[] args) {

        List<Integer> nums = List.of(1,2,2,4);
        MinLengthAfterRemovals minLengthAfterRemovals = new MinLengthAfterRemovals();

        System.out.println(minLengthAfterRemovals.minLengthAfterRemovals(nums));
    }

    // 找出重复次数最多的元素与重复次数次多的元素只差
    public int minLengthAfterRemovals(List<Integer> nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        int k = 0;

        while (k < nums.size()) {
            int repeat = 1;
            while (k < nums.size() - 1 && nums.get(k) == nums.get(k+1)) {
                repeat++;
                k++;
            }
            k++;
            queue.add(repeat);
        }

        int max = queue.poll();
        if (queue.isEmpty())
            return max;
        int second = queue.poll();
        return max - second;
    }
}
