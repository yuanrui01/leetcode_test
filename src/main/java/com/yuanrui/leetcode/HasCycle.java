package com.yuanrui.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<Integer> iset = new HashSet<>();
        if(head == null){
            return false;
        }

        while(head != null){
            if(iset.contains(head.hashCode())){
                return true;
            }else{
                iset.add(head.hashCode());
            }
            head = head.next;
        }

        return false;
    }
}
