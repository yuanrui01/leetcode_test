package com.yuanrui.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class AddTwoNumbers2 {

    public static void main(String[] args) {
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();

        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(7, new ListNode(3));

        ListNode l3 = addTwoNumbers2.addTwoNumbers(l1, l2);
        System.out.println(l3);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head1 = l1;
        ListNode head2 = l2;
        Deque<ListNode> s1 = new ArrayDeque<>();
        Deque<ListNode> s2 = new ArrayDeque<>();
        for ( ;l1 != null; l1 = l1.next)
            s1.push(l1);
        for ( ;l2 != null; l2 = l2.next)
            s2.push(l2);
        while(!s1.isEmpty() && !s2.isEmpty()) {
            ListNode pop1 = s1.pop();
            ListNode pop2 = s2.pop();
            int v1 = pop1.val;
            pop1.val = (v1 + pop2.val + carry) % 10;
            carry = (v1 + pop2.val + carry) / 10;
            pop2.val = pop1.val; // 两条路一起更新了，谁长用谁
            if (s1.isEmpty() && s2.isEmpty())
                if (carry > 0) {
                    ListNode newHead = new ListNode(carry);
                    newHead.next = head1;
                    return newHead;
                } else
                    return head1;
        }
        return s1.isEmpty() ? getHead(s2, head2, carry) : getHead(s1, head1, carry);
    }

    private ListNode getHead(Deque<ListNode> s, ListNode head, int carry) {
        while (!s.isEmpty()) {
            ListNode pop = s.pop();
            int v = pop.val;
            pop.val = (v + carry) % 10;
            carry = (v + carry) / 10;
            if (s.isEmpty())
                if (carry > 0) {
                    ListNode newHead = new ListNode(carry);
                    newHead.next = head;
                    return newHead;
                } else
                    return head;
        }
        return null;
    }
}
