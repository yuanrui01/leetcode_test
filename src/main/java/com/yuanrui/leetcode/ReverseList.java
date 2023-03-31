package com.yuanrui.leetcode;

import java.util.Stack;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/2/20-0:21
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);

        ListNode listNode = reverseList(listNode1);

    }

    public static ListNode reverseList(ListNode head) {
        int listSize = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            listSize++;
        }

        if(listSize <= 1){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;


        while(cur.next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }

        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }else{
            Stack<ListNode> stack = new Stack<>();
            while(head != null){
                stack.push(head);
                head = head.next;
            }
            ListNode dump = new ListNode();
            ListNode itr = stack.pop();
            dump.next = itr;

            while(!stack.isEmpty()){
                itr.next = stack.pop();
                itr = itr.next;
            }

            itr.next = null;
            return dump.next;
        }
    }
}
