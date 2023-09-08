package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 933. 最近的请求次数
 */
public class RecentCounter {

    List<Integer> il;
    public RecentCounter() {
        il = new ArrayList<>();
    }

    public int ping(int t) {
        Iterator<Integer> itr = il.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            if (t - next > 3000)
                itr.remove();
            else
                break;
        }
        il.add(t);
        return il.size();
    }
}
