package com.yuanrui.leetcode;

/**
 * 707. 设计链表
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 * 实现 MyLinkedList 类：
 * MyLinkedList() 初始化 MyLinkedList 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 */
public class MyLinkedList {

    /**
     * 头节点
     */
    ListNode head;

    int size = 0;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index >= 0 && index < size) {
            ListNode temp = head;
            for (int i = 0; i < index; ++i) {
                temp = temp.next;
            }
            return temp.val;
        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode newHead = new ListNode(val);
            newHead.next = head;
            head = newHead;
        }
        size++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode temp = head;
            for(int i = 0; i < size - 1; ++i) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                addAtHead(val);
            } else {
                ListNode temp = head;
                for(int i = 0; i < index - 1; ++i) {
                    temp = temp.next;
                }
                ListNode newNode = new ListNode(val);
                newNode.next = temp.next;
                temp.next = newNode;
            }
            size++;
        }
        if (index == size) {
            addAtTail(val);
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            ListNode temp = head;
            if (index == size - 1) {
                for (int i = 0; i < size - 1; ++i) {
                    temp = temp.next;
                }
                temp.next = null;
            } else if (index == 0) {
                head = head.next;
            } else {
                for(int i = 0; i < index - 1; ++i) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
            }
            size--;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    //1 2 3
    // ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
    // [[],[1],[3],[1,2],[1],[0],[0]]
    public static void main(String[] args) {
        //["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        //[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        System.out.println(myLinkedList.get(4));
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);

//        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//        myLinkedList.get(1);              // 返回 2
//        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//        myLinkedList.get(1);              // 返回 3

        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.deleteAtIndex(0);

        System.out.println(myLinkedList.get(0) + ' ' + myLinkedList.get(1) + ' ' + myLinkedList.get(2));
    }
}
