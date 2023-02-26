package com.yuanrui.leetcode;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/2/20-0:42
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode();

        if(list1==null&&list2==null){
            return newList;
        }

        ListNode temp = newList;
        while(list1!=null&& list2!=null){
            if(list1.val < list2.val){
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
        }

        while(list1!=null){
            temp.next = list1;
            list1 = list1.next;
        }

        while(list2!=null){
            temp.next = list2;
            list2 = list2.next;
        }

        newList = newList.next;

        return newList;
    }
}
