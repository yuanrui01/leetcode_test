package com.yuanrui.leetcode;

/**
 * 622. 设计循环队列
 * @author: yuanrui
 */
class MyCircularQueue {
    int[] cheat;
    int capacity;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        cheat = new int[k + 1];
        front = rear = 0;
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        cheat[rear] = value;
        rear = (rear + 1)%(capacity + 1);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        front = (front + 1) % (capacity + 1);
        return true;
    }

    public int Front() {
        if(isEmpty())
            return -1;
        return cheat[front];
    }

    public int Rear() {
        if(isEmpty())
            return -1;
        return cheat[rear - 1 >= 0 ? rear - 1 : capacity];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % (capacity + 1) == front;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1);
        myCircularQueue.enQueue(2);
        myCircularQueue.enQueue(3);
        myCircularQueue.enQueue(4);
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        myCircularQueue.enQueue(4);
        System.out.println(myCircularQueue.Rear());
    }
}
