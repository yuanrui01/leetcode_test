package org2.example;

/**
 * description 双重锁检查，懒加载，线程安全，不浪费内存空间，执行效率高
 * @author yuanrui
 * @email xdyrfree@gmail.com
 * @date 2023/3/19-23:30
 */
public class Singleton4 {

    private Singleton4(){}

    //禁止指令重排序，防止DCL失效，设置了内存屏障
    private static volatile Singleton4 instance;

    public static Singleton4 getInstance(){
        if(instance == null){
            synchronized (Singleton4.class){
                if(instance == null){
                    instance = new Singleton4();
                }
            }
        }

        return instance;
    }
}
