package com.yuanrui.leetcode;

import java.util.Stack;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/2/20-0:21
 */
public class ReverseList {

    private ListNode ans;
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

    //ssh提交验证
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

    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }else{
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }


    public void recursive(ListNode pre, ListNode head) {
        if (head == null || head.next == null){
            ans = head;
            return;
        }
        recursive(head, head.next);
        head.next = pre;
    }
}
