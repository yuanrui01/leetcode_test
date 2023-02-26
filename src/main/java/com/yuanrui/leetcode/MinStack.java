package com.yuanrui.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * descritpton: 最小栈
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/2/26-19:03
 */
public class MinStack {
    public static void main(String[] args) {
/*        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // 返回 -3.
        minStack.pop();
        minStack.top();      // 返回 0.
        minStack.getMin();   // 返回 -2.*/
        System.out.println(Math.sqrt(10));;
    }
    
    Stack<Integer> stack;
    MinNode head;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(head == null){
            head = new MinNode(val,null);
        }else{
            head = new MinNode(Math.min(head.min, val),head);
        }
    }

    public void pop() {
        head = head.nextNode;
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return head.min;
    }
}

class MinNode{
    int min;
    MinNode nextNode;

    public MinNode(int min, MinNode nextNode) {
        this.min = min;
        this.nextNode = nextNode;
    }
}