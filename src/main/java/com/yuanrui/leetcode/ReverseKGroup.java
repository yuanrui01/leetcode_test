package com.yuanrui.leetcode;

/**
 * 25. K 个一组翻转链表
 * @author: yuanrui
 */
public class ReverseKGroup {

    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        reverseKGroup(head, 2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode tmp = head;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }

        ListNode dumb = new ListNode(0, head);
        tmp = dumb;

        // k组一个循环
        while (n >= k) {
            n -= k;
            int times = k;

            ListNode pre = null, next = null;
            ListNode cur = tmp.next;
            while (times > 0) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                times--;
            }
            next = tmp.next;
            tmp.next.next = cur;
            tmp.next = pre;
            tmp = next;
        }

        return dumb.next;
    }
}
