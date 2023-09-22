package com.yuanrui.leetcode;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 2. 两数相加
 */
public class AddTwoNumbers {

    /**
     * l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * [8,9,9,9,0,0,0,1]
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
        ListNode l3 = addTwoNumbers(l1, l2);

        System.out.println(l3);

//        AtomicReference<ListNode> nodeRef = new AtomicReference<>();
//
//        System.out.println(nodeRef.get());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int carry = 0;
        ListNode pre = null;
        while (l1 != null && l2!= null) {
            pre = l1;
            int v1 = l1.val;
            l1.val = (v1 + l2.val + carry)%10;
            carry = (v1 + l2.val + carry)/10;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 == null) {
                if (carry > 0)
                    pre.next = new ListNode(carry);
                return head;
            }
        }
        if (l1 == null) {
            pre.next = l2;
        }
        pre = pre.next;
        while (pre != null) {
            int v = pre.val;
            pre.val = (v + carry)%10;
            carry = (v + carry)/10;
            if (pre.next == null && carry > 0) {
                pre.next = new ListNode(carry);
                break;
            }
            pre = pre.next;
        }
        return head;
    }
}


