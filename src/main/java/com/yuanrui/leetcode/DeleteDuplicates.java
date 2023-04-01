package com.yuanrui.leetcode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode preNode = head;
        ListNode itr = head;
        ListNode dump = new ListNode();
        dump.next = itr;
        while(head != null){
            if(head.val != preNode.val){
                itr.next = head;
                itr = itr.next;
                preNode = head;
            }
            head = head.next;
        }

        itr.next = null;
        return dump.next;
    }
}
