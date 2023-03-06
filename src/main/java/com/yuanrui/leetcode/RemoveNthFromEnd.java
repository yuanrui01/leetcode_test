package com.yuanrui.leetcode;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumbNode = new ListNode();
        dumbNode.next = head;
        ListNode slowPtr = dumbNode;
        ListNode quickPtr = dumbNode;
        while(n >= 0){
            quickPtr = quickPtr.next;
            n--;
        }
        while(quickPtr != null){
            quickPtr = quickPtr.next;
            slowPtr = slowPtr.next;
        }

        slowPtr.next = slowPtr.next.next;

        return dumbNode.next;
    }
}
