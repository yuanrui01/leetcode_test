package com.yuanrui.leetcode;

import java.util.ArrayList;
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
        il.add(t);
        il.removeIf(i-> t-i>3000);
        return il.size();
    }
}
