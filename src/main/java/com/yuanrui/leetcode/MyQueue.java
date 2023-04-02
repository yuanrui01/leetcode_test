package com.yuanrui.leetcode;

import java.util.Stack;

/**
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/4/2-11:48
 */
public class MyQueue {

    /*专门用于压入*/
    private Stack<Integer> pushStack;
    /*专门用于弹出*/
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if(!popStack.isEmpty()){
            return popStack.pop();
        }else{
            while(!pushStack.isEmpty())
                popStack.add(pushStack.pop());
            return popStack.pop();
        }
    }

    public int peek() {
        if(!popStack.isEmpty()){
            return popStack.peek();
        }else{
            while(!pushStack.isEmpty())
                popStack.add(pushStack.pop());
            return popStack.peek();
        }
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
