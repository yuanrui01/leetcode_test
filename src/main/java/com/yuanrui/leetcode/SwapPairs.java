package com.yuanrui.leetcode;

public class SwapPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        if (count == 1) {
            return head;
        }

        ListNode dumb = new ListNode(0);
        dumb.next = head;
        temp = dumb;

        while (count > 1) {
            ListNode nextNode = temp.next;
            ListNode nextNextNode = temp.next.next;
            temp.next = nextNextNode;
            nextNode.next = nextNextNode.next;
            nextNextNode.next = nextNode;
            temp = nextNode;
            count -= 2;
        }

        return dumb.next;
    }
}
