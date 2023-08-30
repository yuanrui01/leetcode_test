package com.yuanrui.leetcode;

/**
 * 92. 反转链表 II
 * @author: yuanrui
 */
public class ReverseBetween {

    public static void main(String[] args) {
        ListNode head = new ListNode(-3, new ListNode(-2, new ListNode(3, new ListNode(-5, new ListNode(3, new ListNode(4, new ListNode(-4)))))));

        reverseBetween(head, 5, 7);
    }


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;

        ListNode dumb = new ListNode(0, head);
        ListNode tmp = dumb;
        int times = right - left + 1;
        while(left - 1 > 0) {
            tmp = tmp.next;
            left--;
        }

        ListNode pre = null;
        ListNode cur = tmp.next;
        while (times > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            times--;
        }
        tmp.next.next = cur;
        tmp.next = pre;

        return dumb.next;
    }

    public static ListNode reverseList(ListNode head, int right) {
        if(head == null || head.next == null){
            return head;
        }else{
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = head.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
