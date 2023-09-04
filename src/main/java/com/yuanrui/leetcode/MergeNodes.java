package com.yuanrui.leetcode;

/**
 * 2181. 合并零之间的节点
 * @author: yuanrui
 */
public class MergeNodes {


    public ListNode mergeNodes(ListNode head) {
        ListNode tmp = head.next;

        while (tmp.next != null) {
            while (tmp.next.val != 0) {
                tmp.val += tmp.next.val;
                tmp.next = tmp.next.next;
            }
            if (tmp.next.next == null) {
                tmp.next = null;
                break;
            }
            tmp = tmp.next;
        }

        return head.next;
    }
}
