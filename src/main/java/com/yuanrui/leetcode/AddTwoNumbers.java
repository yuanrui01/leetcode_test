package com.yuanrui.leetcode;

import java.util.List;
import java.util.Stack;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
        addTwoNumbers(l1,l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;

        int carry = 0;
        int v1 = 0;
        int v2 = 0;
        while(l1 != null && l2 != null){
            node.next = new ListNode(0);
            node = node.next;
            v1 = l1.val;
            v2 = l2.val;
            node.val = (v1 + v2 + carry) % 10;
            l1 = l1.next;
            l2 = l2.next;
            carry = (v1 + v2 + carry) / 10;
        }

        while (l1 != null){
            node.next = new ListNode(0);
            node = node.next;
            node.val = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
        }

        while (l2 != null){
            node.next = new ListNode(0);
            node = node.next;
            node.val = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }

        if(carry != 0){
            node.next = new ListNode(carry);
        }
        return head.next;
    }
}


