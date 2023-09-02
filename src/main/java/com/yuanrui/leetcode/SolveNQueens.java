package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 *  N 皇后
 * @author: yuanrui
 */
public class SolveNQueens {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(IntStream.rangeClosed(0,4).toArray()));

        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        if (n == 1)
            return List.of(List.of("Q"));
        int[] line = IntStream.rangeClosed(0, n - 1).toArray();
        boolean[] colFlag = new boolean[n];
        boolean[] forwardSlash = new boolean[2 * n - 1];
        boolean[] backSlash = new boolean[2 * n - 1];
        List<List<String>> ans = new ArrayList<>();
        dfs(line, 0, ans, colFlag, forwardSlash, backSlash);
        return ans;
    }

    private static void dfs(int[] line, int idx, List<List<String>> ans, boolean[] colFlag, boolean[] forwardSlash, boolean[] backSlash) {
        if (idx == line.length) {
            ans.add(generateStr(line));
            return;
        }

        for (int i = idx; i < line.length; ++i) {
            if (!colFlag[line[i]] && !forwardSlash[idx + line[i]] && !backSlash[idx + line.length - 1 - line[i]]) {
                colFlag[line[i]] = true;
                forwardSlash[idx + line[i]] = true;
                backSlash[idx + line.length - 1 - line[i]] = true;
                swap(line, i, idx);
                // ====================
                dfs(line, idx + 1, ans, colFlag, forwardSlash, backSlash);
                // ====================
                swap(line, i, idx);
                backSlash[idx + line.length - 1 - line[i]] = false;
                forwardSlash[idx + line[i]] = false;
                colFlag[line[i]] = false;
            }
        }
    }

    private static void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    private static List<String> generateStr(int[] line) {
        List<String> slist = new ArrayList<>();
        for (int k : line) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < line.length; ++j)
                if (j == k)
                    sb.append("Q");
                else
                    sb.append(".");
            slist.add(sb.toString());
        }
        return slist;
    }
}
