package com.yuanrui.leetcode;

import java.util.List;

public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if(head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head.next;
        }

        ListNode quickPtr = head;
        ListNode slowPtr = head;

        while(quickPtr != null && quickPtr.next != null){
            slowPtr = slowPtr.next;
            quickPtr = quickPtr.next.next;
        }

        return slowPtr;
    }
}
