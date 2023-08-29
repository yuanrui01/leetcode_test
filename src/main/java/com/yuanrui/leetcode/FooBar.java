package com.yuanrui.leetcode;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/8/29-18:34
 */
public class FooBar {

    private int n;

    private final AtomicBoolean fooflag = new AtomicBoolean(true);
    private final AtomicBoolean barflag = new AtomicBoolean(false);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (barflag.get()){
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barflag.set(true);
            fooflag.set(false);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(fooflag.get()){
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooflag.set(true);
            barflag.set(false);
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);


        Thread thread1 = new Thread(() -> {
            try {
                fooBar.foo(()-> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                fooBar.bar(()-> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
