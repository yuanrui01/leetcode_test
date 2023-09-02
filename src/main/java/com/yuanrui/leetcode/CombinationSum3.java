package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 216. 组合总和 III
 * @author: yuanrui
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        combinationSum3(9,45);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        int[] numbers = IntStream.rangeClosed(1, 9).toArray();
        if (k == 1)
            Arrays.stream(numbers).forEach(i->ans.add(List.of(i)));
        else
            dfs(numbers, k, n,0, elem, ans);
        return ans;
    }


    private static void dfs(int[] numbers, int k, int n, int idx, List<Integer> elem, List<List<Integer>> ans) {
        if (elem.size() == k) {
            if (elem.stream().reduce(0,Integer::sum) == n)
                ans.add(new ArrayList<>(elem));
            return;
        }
        if (elem.size() + (numbers.length - idx) < k)
            return;

        for (int i = idx; i < numbers.length; ++i) {
            elem.add(numbers[i]);
            dfs(numbers, k, n,i+1, elem, ans);
            elem.remove(elem.size() - 1);
        }
    }
}
