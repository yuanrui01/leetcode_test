package com.yuanrui.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 1409. 查询带键的排列
 * @author: yuanrui
 */
public class ProcessQueries {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(IntStream.rangeClosed(1,6).toArray()));
    }


    // 有树状数组高级做法，日后再战！！！！！！
    public int[] processQueries(int[] queries, int m) {
        int[] ans = new int[queries.length];
        int[] permutation = IntStream.rangeClosed(1, m).toArray();
        for (int i = 0; i <queries.length; ++i) {
            int target = queries[i];

            for (int j = 0; j < permutation.length; ++j) {
                if (target == permutation[j]) {
                    ans[i] = j;
                    while(j > 0) {
                        int tmp = permutation[j];
                        permutation[j] = permutation[j - 1];
                        permutation[j - 1] = tmp;
                        j--;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}
