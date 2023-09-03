package com.yuanrui.leetcode;

/**
 * 2095. 删除链表的中间节点
 * @author: yuanrui
 */
public class deleteMiddle {


    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;
        ListNode dump = new ListNode(0, head);
        ListNode slow = dump;
        ListNode fast = dump;

        while (fast.next!=null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return dump.next;
    }
}
