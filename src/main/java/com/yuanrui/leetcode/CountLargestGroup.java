package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 1399. 统计最大组的数目
 */
public class CountLargestGroup {

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
    }
    public static int countLargestGroup(int n) {
        int ans = 0;
        if (n == 1)
            return 1;
        Map<Integer, Integer> map = new HashMap<>();
        int[] numArr = IntStream.rangeClosed(1, n).toArray();
        for (int i : numArr)
            map.merge(digitSum(i), 1, Integer::sum);
        int max = 0;
        for (Integer value : map.values()) {
            max = Math.max(value, max);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max)
                ans++;
        }
        return ans;
    }

    private static int digitSum(int n) {
        int res = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            res += c - '0';
        }
        return res;
    }
}
