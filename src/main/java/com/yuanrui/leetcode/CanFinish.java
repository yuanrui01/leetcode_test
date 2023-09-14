package com.yuanrui.leetcode;

import java.sql.Array;
import java.util.*;

/**
 * 207. Course Schedule 课程表
 * @author: yuanrui
 */
public class CanFinish {

    public static void main(String[] args) {
//        int numCourses = 4;
//        int[][] prerequisites = {{2,0},{1,0},{3,1},{3,2},{1,3}};
//        System.out.println(canFinish(numCourses, prerequisites));
        int numCourses = 20;
        int[][] prerequisites = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        System.out.println(canFinish2(numCourses, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] finish = new boolean[numCourses];
        Map<Integer,List<Integer>> map = new HashMap<>();
        Arrays.fill(finish, true);
        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == prerequisite[1])
                return false;
            finish[prerequisite[0]] = false;
            if (map.get(prerequisite[0]) != null) {
                map.get(prerequisite[0]).add(prerequisite[1]);
            } else {
                List<Integer> required = new ArrayList<>();
                required.add(prerequisite[1]);
                map.put(prerequisite[0], required);
            }
        }

        // 先把不需要依赖的学完了，再看需要依赖的，一旦出现环路就返回false
        for (int[] prerequisite : prerequisites) {
            if (!(finish[prerequisite[0]])) {
                // 判断先修课程是否可完成，判断是否有环。。
                int lesson = prerequisite[0];
                Set<Integer> set = new HashSet<>();
                if (!checkRequisite(lesson, map, set, finish))
                    return false;
            }
        }
        return true;
    }

    /**
     * 检查依赖树
     * @return
     */
    private static boolean checkRequisite(int lesson, Map<Integer,List<Integer>> map, Set<Integer> set, boolean[] finish) {
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
        return true;
    }


    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] ans = topoSort(numCourses, prerequisites);
        return ans.length == numCourses;
    }

    private static int[] topoSort(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
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
            ans.add(poll);
            for (Integer i : g[poll])
                if (--inDegree[i] == 0)
                    q.add(i);
        }
        return ans.stream().mapToInt(i->i).toArray();
    }


}
