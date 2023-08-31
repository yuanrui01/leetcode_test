package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PairSum {

    public static void main(String[] args) {
        System.out.println(pairSum(new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))))));
    }

    /**
     * 5 4 2 1
     * @param head
     * @return
     */
    public static int pairSum(ListNode head) {
        List<Integer> ilist = new ArrayList<>();
        int listSize = 0;
        while(head != null) {
            ilist.add(head.val);
            head = head.next;
            listSize++;
        }

        int max = Integer.MIN_VALUE;
        int middle = (listSize - 1)/2 + 1;
        for (int i = 0; i < middle; ++i) {
            max = Math.max(max, ilist.get(i) + ilist.get(listSize - i - 1));
        }
        return max;
    }
}
