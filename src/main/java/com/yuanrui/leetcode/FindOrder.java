package com.yuanrui.leetcode;

import java.util.*;

/**
 * 210. 课程表 II
 * @author: yuanrui
 */
public class FindOrder {
    List<Integer> ans;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ans = new ArrayList<>();
        boolean[] finish = new boolean[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.fill(finish, true);
        // 先把不需要先修的课程mark为true
        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == prerequisite[1])
                return new int[0];
            finish[prerequisite[0]] = false;
            if (map.get(prerequisite[0]) != null) {
                map.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                List<Integer> required = new ArrayList<>();
                required.add(prerequisite[1]);
                map.put(prerequisite[0], required);
            }
        }

        for (int i = 0; i < numCourses; ++i) {
            if (finish[i])
                ans.add(i);
        }

        // 先把不需要依赖的学完了，再看需要依赖的，一旦出现环路就返回false
        for (int[] prerequisite : prerequisites) {
            if (!(finish[prerequisite[0]])) {
                // 判断先修课程是否可完成，判断是否有环。。
                int lesson = prerequisite[0];
                Set<Integer> set = new TreeSet<>();
                if (!checkRequisite(lesson, map, set, finish))
                    return new int[0];
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }

    /**
     * 检查依赖树
     */
    private boolean checkRequisite(int lesson, Map<Integer,List<Integer>> map, Set<Integer> set, boolean[] finish) {
        List<Integer> requisite = map.get(lesson);
        for (int i = 0 ; i < requisite.size(); ++i) {
            if (finish[requisite.get(i)])
                continue;
            if (set.contains(requisite.get(i))) {
                return false;
            } else {
                set.add(lesson);
                if (!checkRequisite(requisite.get(i), map, set, finish))
                    return false;
                set.remove(lesson);
            }
        }
        finish[lesson] = true;
        ans.add(lesson);
        return true;
    }

    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] ans = topoSort(numCourses, prerequisites);
        return ans.length != numCourses ? new int[0] : ans;
    }

    private static int[] topoSort(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        List<Integer>[] g = new List[numCourses];
        Arrays.setAll(g, e -> new ArrayList<>());
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            g[prerequisite[1]].add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; ++i)
            if (inDegree[i] == 0)
                q.add(i);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            order.add(poll);
            for (Integer i : g[poll])
                if (--inDegree[i] == 0)
                    q.add(i);
        }
        return order.stream().mapToInt(i->i).toArray();
    }
}
