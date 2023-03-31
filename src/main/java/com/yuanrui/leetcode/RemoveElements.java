package com.yuanrui.leetcode;

public class RemoveElements {

    public static void main(String[] args) {
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(6,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6)))))));

        removeElements(node,6);
    }


    public static ListNode removeElements(ListNode head, int val) {
        ListNode dumb = new ListNode();
        ListNode itr = dumb;

        while(head!=null){
            if(head.val != val){
                itr.next = head;
                itr = itr.next;
            }
            head = head.next;
        }

        return dumb.next;
    }
}
