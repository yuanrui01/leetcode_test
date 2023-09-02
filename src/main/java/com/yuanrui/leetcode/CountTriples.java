package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 1925. 统计平方和三元组的数目
 * @author: yuanrui
 */
public class CountTriples {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        countTriples(12);

        System.out.println(System.currentTimeMillis() - l);

    }

    public static int countTriples(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> triple = new ArrayList<>();
        int[] num = IntStream.rangeClosed(1, n).toArray();
        dfs(num, 0, ans, triple);
        return ans.size();
    }

    private static void dfs(int[] num, int idx, List<List<Integer>> ans, List<Integer> triple) {

        if (idx == 3)
            if ((triple.get(0)*triple.get(0) + triple.get(1)*triple.get(1)) == triple.get(2)*triple.get(2))
                ans.add(triple);

        for (int i = idx; i < num.length; ++i) {
            triple.add(num[i]);
            dfs(num, idx + 1, ans, triple);
            triple.remove(triple.size() - 1);
        }
    }
}
