package com.yuanrui.leetcode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(101,head);
        while(dump.next != null){
            if(dump.next.val == dump.val)
                dump.next = dump.next.next;
            else
                dump = dump.next;
        }
        return head;
    }
}
