package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/9-8:45
 */
public class DeleteDuplicates2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(101,head);
        ListNode preHead = dump;
        int repeatVal;
        while(dump != null && dump.next != null && dump.next.next != null){
            if(dump.next.val == dump.next.next.val){
                repeatVal = dump.next.val;
                while(dump.next != null && dump.next.val == repeatVal){
                    dump.next = dump.next.next;
                }
            }else{
                dump = dump.next;
            }
        }
        return preHead.next;
    }
}
