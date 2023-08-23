package com.yuanrui.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> ilA = new ArrayList<>();
        List<ListNode> ilB = new ArrayList<>();
        while (headA != null) {
            ilA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            ilB.add(headB);
            headB = headB.next;
        }

        int sizeA = ilA.size();
        int sizeB = ilB.size();


        ListNode result = null;
        if (sizeA == 0 || sizeB == 0) {
            return result;
        } else {
            int startA = sizeA - 1;
            int startB = sizeB - 1;
            while (startA >= 0 && startB >=0) {
                if (ilA.get(startA) != ilB.get(startB)) {
                    return result;
                } else {
                    result = ilA.get(startA);
                    startA--;
                    startB--;
                }
            }

            return result;
        }
    }
}
