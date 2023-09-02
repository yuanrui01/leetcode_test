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

        System.out.println(countTriples(5));

        System.out.println(System.currentTimeMillis() - l);

    }

    public static int countTriples(int n) {
        int[] ans = new int[]{0};
        int[] triple = new int[3];
        int[] num = IntStream.rangeClosed(1, n).toArray();
        dfs(num, 0, ans, triple);
        return ans[0];
    }

    private static void dfs(int[] num, int idx, int[] ans, int[] triple) {

        if (idx == 3) {
            if ((triple[0]*triple[0] + triple[1]*triple[1]) == triple[2]*triple[2])
                ans[0]++;
            return;
        }

        for (int i = idx; i < num.length; ++i) {
            triple[idx] = num[i];

            dfs(num, idx + 1, ans, triple);
        }
    }
}
