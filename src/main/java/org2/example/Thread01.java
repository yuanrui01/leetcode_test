package org2.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: yuanrui
 * @email: xdyrfree@gmail.com
 * @date: 2023/7/17-20:25
 */
public class Thread01 {

    private static final int TOTAL_COUNT = 100;
    private static volatile int count = 0;
    //可取代
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // 创建一个栅栏，设置等待数量为2
        CyclicBarrier barrier = new CyclicBarrier(2, () -> {});

        Thread threadA = new Thread(() -> {
            while (count < TOTAL_COUNT) {
                if (count % 2 == 0) {
                    System.out.println("线程A：A - " + (count + 1));
                    count++;
                }

                try {
                    barrier.await();  // 等待其他线程到达栅栏
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (count < TOTAL_COUNT) {
                if (count % 2 != 0) {
                    System.out.println("线程B：B - " + (count + 1));
                    count++;
                }
                try {
                    barrier.await();  // 等待其他线程到达栅栏
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println("主线程继续执行");
    }
}
