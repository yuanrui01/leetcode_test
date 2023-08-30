package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodesBetweenCriticalPoints {

    public static void main(String[] args) {
        ListNode head = new ListNode(2, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> ilist = new ArrayList<>();
        while (head != null) {
            ilist.add(head.val);
            head = head.next;
        }
        if (ilist.size() < 3)
            return new int[]{-1,-1};

        int[] iArr = ilist.stream().mapToInt(i->i).toArray();
        List<Integer> criticalPoints = new ArrayList<>();

        int preCritical = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < ilist.size() - 1; ++i)
            if ((iArr[i] > iArr[i - 1] && iArr[i] > iArr[i + 1]) ||
                    (iArr[i] < iArr[i - 1] && iArr[i] < iArr[i + 1])) {
                if (preCritical != -1) {
                    min = Math.min(min, i - preCritical);
                }
                preCritical = i;
                criticalPoints.add(i);
            }

        if (criticalPoints.size() < 2)
            return new int[]{-1, -1};
        else
            return new int[]{min, criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0)};
    }
}
