package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: yuanrui
 */
public class CountStudents {

    public int countStudents(int[] students, int[] sandwiches) {
        int iSand = 0;
        int len = students.length;

        Deque<Integer> q = new ArrayDeque<>();
        for(int i = len - 1; i >= 0; --i)
            q.add(students[i]);
        while (true) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Integer poll = q.poll();
                if (poll == sandwiches[iSand])
                    iSand++;
                else
                    q.add(poll);
            }
            if (q.size() == size)
                break;
        }

        return len - iSand;
    }
}
