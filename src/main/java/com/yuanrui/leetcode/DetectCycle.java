package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<Integer> hashList  = new HashSet<>();

        while(head != null) {
            if (hashList.contains(head.hashCode())) {
                return head;
            } else {
                hashList.add(head.hashCode());
                head = head.next;
            }
        }

        return null;
    }
}
