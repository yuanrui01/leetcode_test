package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 739. 每日温度
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            int tmp = temperatures[i];
            while (!deque.isEmpty() && tmp > temperatures[deque.peek()]) {
                int preIdx = deque.pop();
                ans[preIdx] = i - preIdx;
            }
            deque.push(i);
        }
        return ans;
    }
}
