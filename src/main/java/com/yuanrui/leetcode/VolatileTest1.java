package com.yuanrui.leetcode;

public class VolatileTest1 {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest1 test = new VolatileTest1();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
        Thread.sleep(2000);
        System.out.println(test.inc);
    }
}
