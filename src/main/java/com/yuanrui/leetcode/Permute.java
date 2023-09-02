package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 46. 全排列
 * @author: yuanrui
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        backtrack(n, nums, res, 0);
        return res;
    }

    public void backtrack(int n, int[] output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(Arrays.stream(output).boxed().collect(Collectors.toList()));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            swap(output, first, i);
        }
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack2(n, output, res, 0);
        return res;
    }

    public void backtrack2(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack2(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
