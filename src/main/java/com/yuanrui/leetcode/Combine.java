package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 77. 组合
 * @author: yuanrui
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        int[] numbers = IntStream.rangeClosed(1, n).toArray();
        if (k == 1)
            Arrays.stream(numbers).forEach(i->ans.add(List.of(i)));
        else
            dfs(numbers, k, 0, elem, ans);
        return ans;
    }


    private static void dfs(int[] numbers, int k, int idx, List<Integer> elem, List<List<Integer>> ans) {
        if (elem.size() == k) {
            ans.add(new ArrayList<>(elem));
            return;
        }
        if (elem.size() + (numbers.length - idx) < k)
            return;

        for (int i = idx; i < numbers.length; ++i) {
            elem.add(numbers[i]);
            dfs(numbers, k, i+1, elem, ans);
            elem.remove(elem.size() - 1);
        }
    }
}
