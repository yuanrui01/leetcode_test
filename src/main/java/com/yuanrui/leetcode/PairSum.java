package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2130. 链表最大孪生和
 * @author: yuanrui
 */
public class PairSum {

    public static void main(String[] args) {
        System.out.println(pairSum(
                new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))))
        ));
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //此时slow的后继就是链表的后半部分。对slow.next进行反转
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        int max = Integer.MIN_VALUE;
        while(pre != null) {
            max = Math.max(max, head.val + pre.val);
            head = head.next;
            pre = pre.next;
        }
        return max;
    }
}
