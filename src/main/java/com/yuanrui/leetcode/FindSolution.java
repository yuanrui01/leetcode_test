package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1237. 找出给定方程的正整数解
 */
public class FindSolution {

    interface CustomFunction {
         public int f(int x, int y);
    };
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= z; ++i)
            for (int j = 1; j <= z; ++j)
                if (customfunction.f(i,j) == z)
                    ans.add(List.of(i,j));
        return ans;
    }
}
