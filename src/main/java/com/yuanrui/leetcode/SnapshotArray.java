package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1146. 快照数组
 */
public class SnapshotArray {

    List<List<int[]>> snapshots;
    int version;

    public SnapshotArray(int length) {
        version = 0;
        snapshots = new ArrayList<>();
        for (int i = 0; i < length; i++)
            snapshots.add(new ArrayList<>());
    }

    public void set(int index, int val) {
        List<int[]> snapshot = snapshots.get(index);
        if (!snapshot.isEmpty() && snapshot.get(snapshot.size() - 1)[0] == version)
            snapshot.get(snapshot.size() - 1)[1] = val;
        else
            snapshots.get(index).add(new int[]{version, val});
    }

    // 此处超时，需要优化
    public int snap() {
        return version++;
    }

    public int get(int index, int snap_id) {
        // 查找第一个小于等于snap_id的元素
        List<int[]> snapshot = snapshots.get(index);
        int left = 0;
        int right = snapshot.size() - 1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (snapshot.get(middle)[0] <= snap_id)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return left == 0 ? 0 : snapshot.get(left - 1)[1];
    }

    private static int lessEqualTarget(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (list.get(middle) <= target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return left == 0 ? -1 : left - 1;
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArray = new SnapshotArray(2);
        snapshotArray.snap();
        System.out.println(snapshotArray.get(1,0));
        System.out.println(snapshotArray.get(0,0));
        snapshotArray.set(1,8);
        System.out.println(snapshotArray.get(1,0));
        snapshotArray.set(0,20);
        System.out.println(snapshotArray.get(0,0));
        snapshotArray.set(0,7);
    }
}
