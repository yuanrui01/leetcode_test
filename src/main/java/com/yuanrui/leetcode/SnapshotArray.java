package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1146. 快照数组
 * @author: yuanrui
 */
public class SnapshotArray {

    List<Integer>[] snapshot;
    int[] current;

    public SnapshotArray(int length) {
        snapshot  = new ArrayList[length];
        for (int i = 0; i < length; ++i)
            snapshot[i] = new ArrayList<>();
        current = new int[length];
    }

    public void set(int index, int val) {
        current[index] = val;
    }

    public int snap() {
        for (int i = 0; i < current.length; ++i) {
            snapshot[i].add(current[i]);
        }
        return snapshot[0].size() - 1;
    }

    public int get(int index, int snap_id) {
        List<Integer> iSnapShot = snapshot[index];
        return iSnapShot.get(snap_id);
    }

    public static void main(String[] args) {

        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0,5);
        System.out.println(snapshotArray.snap());
    }
}
