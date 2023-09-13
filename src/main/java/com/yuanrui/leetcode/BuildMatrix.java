package com.yuanrui.leetcode;


import java.util.*;

/**
 * 2392. 给定条件下构造矩阵
 */
public class BuildMatrix {

    public int[] topoSort(int k, int[][] edges) {
        List<Integer>[] g = new ArrayList[k];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] inDeg = new int[k];
        for (int[] e : edges) {
            int x = e[0] - 1;
            int y = e[1] - 1;
            g[x].add(y);
            inDeg[y]++;
        }
        List<Integer> order = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<Integer>();

        for (int i = 0; i < k; ++i)
            if (inDeg[i] == 0)
                q.push(i);
        while (!q.isEmpty()) {
            int x = q.pop();
            order.add(x);
            for (int y : g[x])
                if (--inDeg[y] == 0)
                    q.push(y);
        }
        return order.stream().mapToInt(i->i).toArray();
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] row = topoSort(k, rowConditions);
        int[] col = topoSort(k, colConditions);
        if (row.length < k || col.length < k) return new int[0][0];

        int[][] ans = new int[k][k];
        int[] pos = new int[k];
        for (int i = 0; i < k; ++i)
            pos[col[i]] = i;
        for (int i = 0; i < k; ++i)
            ans[i][pos[row[i]]] = row[i] + 1;
        return ans;
    }
}
